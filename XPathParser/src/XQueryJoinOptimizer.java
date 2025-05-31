import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class XQueryJoinOptimizer {

    // 将输入的XQuery查询字符串转换为基于JOIN的优化版本
    public static String optimizeQuery(String xquery) {
        // 提取 for 部分、where 部分和 return 部分的子字符串
        int wherePos = xquery.indexOf("where");
        int returnPos = xquery.indexOf("return");
        String forClause = xquery.substring(xquery.indexOf("for") + 3,
                (wherePos != -1 ? wherePos : returnPos)).trim();
        String whereClause = (wherePos != -1 ?
                xquery.substring(wherePos + 5, returnPos).trim() : "");
        String returnClause = xquery.substring(returnPos + 6).trim();

        // 解析 for 子句，拆分出每个 "变量 in 表达式"
        // 允许多个变量（逗号分隔或换行）列出
        // 如果存在多段 for（无逗号连续），统一替换为逗号形式
        if (forClause.contains("for $")) {
            // 将除第一个之外的 "for $" 替换为 ", $"
            forClause = forClause.replaceAll("\\bfor\\s+\\$", ", $");
        }
        // 按逗号分隔各个迭代定义
        String[] forParts = Arrays.stream(forClause.split(","))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .toArray(String[]::new);

        List<String> varList = new ArrayList<>();
        List<String> exprList = new ArrayList<>();
        for (String part : forParts) {
            // 确保没有前缀的 "for "
            if (part.startsWith("for ")) {
                part = part.substring(4).trim();
            }
            // 按 " in " 划分变量名和迭代表达式
            int inIndex = part.indexOf(" in ");
            if (inIndex == -1) continue;
            String varName = part.substring(0, inIndex).trim();
            String expr = part.substring(inIndex + 4).trim();
            if (varName.startsWith("$")) {
                varName = varName.substring(1); // 去掉开头的$
            }
            varList.add(varName);
            exprList.add(expr);
        }

        int n = varList.size();
        // 建立变量名到索引的映射，便于快速查找
        Map<String, Integer> varIndexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            varIndexMap.put(varList.get(i), i);
        }

        // 使用并查集（Union-Find）根据变量依赖关系分组
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;

        // 查找并查集根
        java.util.function.IntUnaryOperator findRoot = new java.util.function.IntUnaryOperator() {
            public int applyAsInt(int x) {
                while (parent[x] != x) {
                    parent[x] = parent[parent[x]];
                    x = parent[x];
                }
                return x;
            }
        };
        // 合并两个集合
        java.util.function.BiConsumer<Integer,Integer> union = (a, b) -> {
            int rootA = findRoot.applyAsInt(a);
            int rootB = findRoot.applyAsInt(b);
            if (rootA != rootB) {
                parent[rootB] = rootA;
            }
        };

        // 遍历每个变量的迭代表达式，查找其中引用的其他变量
        Pattern varPattern = Pattern.compile("\\$([A-Za-z_0-9]+)");
        for (int i = 0; i < n; i++) {
            Matcher m = varPattern.matcher(exprList.get(i));
            while (m.find()) {
                String refVarName = m.group(1);
                if (varIndexMap.containsKey(refVarName)) {
                    int j = varIndexMap.get(refVarName);
                    if (j < i) {
                        // 变量 i 依赖于先前定义的变量 j，合并它们的集合
                        union.accept(i, j);
                    }
                }
            }
        }

        // 收集并查集结果，将每个集合的成员索引列表存储
        Map<Integer, List<Integer>> groupMembers = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int root = findRoot.applyAsInt(i);
            groupMembers.computeIfAbsent(root, k -> new ArrayList<>()).add(i);
        }
        // 整理子查询组列表，并按原变量出现顺序排序每组和组本身
        List<List<Integer>> groups = new ArrayList<>(groupMembers.values());
        groups.forEach(Collections::sort);
        groups.sort(Comparator.comparingInt(list -> list.get(0)));

        // 解析 WHERE 子句，区分JOIN条件和常量条件
        List<int[]> joinConds = new ArrayList<>(); // 存储变量索引对的JOIN条件
        Map<Integer, List<String>> constConds = new HashMap<>(); // 存储每个变量索引对应的常量条件列表
        if (!whereClause.isEmpty()) {
            // 按 "and" 分隔多个条件
            String[] conditions = whereClause.split("\\band\\b");
            for (String cond : conditions) {
                cond = cond.trim();
                if (cond.isEmpty()) continue;
                // 去除可能包裹的括号
                if (cond.startsWith("(") && cond.endsWith(")")) {
                    cond = cond.substring(1, cond.length() - 1).trim();
                }
                // 用 " eq " 或 "=" 切分左右两部分
                String[] lr;
                if (cond.contains(" eq ")) {
                    lr = cond.split(" eq ");
                } else if (cond.contains("=")) {
                    lr = cond.split("=");
                } else {
                    continue;
                }
                if (lr.length != 2) continue;
                String left = lr[0].trim();
                String right = lr[1].trim();
                boolean leftVar = left.startsWith("$");
                boolean rightVar = right.startsWith("$");
                if (leftVar && rightVar) {
                    // 变量 = 变量 -> JOIN条件
                    String lv = left.substring(1);
                    String rv = right.substring(1);
                    if (varIndexMap.containsKey(lv) && varIndexMap.containsKey(rv)) {
                        int li = varIndexMap.get(lv);
                        int ri = varIndexMap.get(rv);
                        // 记录变量索引对
                        joinConds.add(new int[]{li, ri});
                    }
                } else if (leftVar && !rightVar) {
                    // 变量 = 常量 -> 保留在子查询过滤
                    String lv = left.substring(1);
                    if (varIndexMap.containsKey(lv)) {
                        int li = varIndexMap.get(lv);
                        constConds.computeIfAbsent(li, k -> new ArrayList<>())
                                .add(left + " eq " + right);
                    }
                } else if (rightVar && !leftVar) {
                    // 常量 = 变量 -> 变量 = 常量也是过滤
                    String rv = right.substring(1);
                    if (varIndexMap.containsKey(rv)) {
                        int ri = varIndexMap.get(rv);
                        constConds.computeIfAbsent(ri, k -> new ArrayList<>())
                                .add(right + " eq " + left);
                    }
                }
            }
        }
        // 过滤掉同组内部的比较（如果有），仅保留跨组JOIN条件
        // 并将JOIN条件按涉及的组分类
        Map<Set<Integer>, List<int[]>> joinCondsByGroupPair = new HashMap<>();
        for (int[] cond : joinConds) {
            int li = cond[0], ri = cond[1];
            // 找到各变量所在组的索引（在 groups 列表中的位置）
            int groupL = findGroupIndex(groups, li);
            int groupR = findGroupIndex(groups, ri);
            if (groupL == groupR) {
                // 同一组内的条件，不作为JOIN，在子查询中已自然满足或不需处理
                continue;
            }
            // 始终保持较小组编号在前，以标准化键
            if (groupL > groupR) {
                int temp = groupL; groupL = groupR; groupR = temp;
                // 对调变量索引对顺序也交换
                int tmpIdx = li; li = ri; ri = tmpIdx;
            }
            Set<Integer> groupPairKey = new LinkedHashSet<>(Arrays.asList(groupL, groupR));
            joinCondsByGroupPair.computeIfAbsent(groupPairKey, k -> new ArrayList<>())
                    .add(new int[]{li, ri});
        }

        // 构造每个子查询的 FLWOR 表达式字符串
        List<String> subqueries = new ArrayList<>();
        for (List<Integer> group : groups) {
            StringBuilder subSb = new StringBuilder();
            // 构建 for 子句部分
            for (int j = 0; j < group.size(); j++) {
                int varIndex = group.get(j);
                String varName = varList.get(varIndex);
                String expr = exprList.get(varIndex);
                if (j == 0) {
                    subSb.append("for $").append(varName).append(" in ").append(expr);
                } else {
                    subSb.append("\n    $").append(varName).append(" in ").append(expr);
                }
                if (j < group.size() - 1) {
                    subSb.append(",");  // 多变量用逗号分隔
                }
            }
            // where 子句（常量条件）
            List<String> groupConstConds = new ArrayList<>();
            for (int varIndex : group) {
                if (constConds.containsKey(varIndex)) {
                    groupConstConds.addAll(constConds.get(varIndex));
                }
            }
            if (!groupConstConds.isEmpty()) {
                subSb.append("\nwhere ");
                // 用 " and " 连接同组内所有常量过滤条件
                subSb.append(String.join(" and ", groupConstConds));
            }
            // return 子句，构造 <tuple>

            subSb.append("\nreturn <tuple> ");
            List<String> tupleElems = new ArrayList<>();
            for (int varIndex : group) {
                String varName = varList.get(varIndex);
                // 将变量整个内容包装在其名字标签下
                tupleElems.add("<" + varName + ">{" + "$" + varName + "}</" + varName + ">");
            }
            // FIXME: comma or not for delimiter?
            subSb.append(String.join(" ", tupleElems));
            subSb.append(" </tuple>");
            subqueries.add(subSb.toString());
        }
        // 如果只有一个子查询组，无需JOIN，直接输出优化结果（相当于无变化或仅常量过滤）
        if (subqueries.size() == 1) {
            // 替换 RETURN 中的变量为 $tuple/var/*，并构造最终查询
            String singleSubquery = subqueries.get(0);
            String newReturn = replaceReturnVariables(returnClause, varList);
            // 将单个子查询结果作为 tuple 序列迭代输出
            return "for $tuple in (\n" + singleSubquery + "\n)\nreturn " + newReturn;
        }

        // 对多个子查询组，按JOIN条件将它们连接
        // 选择合适的连接顺序：每次找出一个尚未连接的组，与已连接部分存在JOIN条件则加入
        String currentJoinExp = subqueries.get(0);
        Set<Integer> joinedGroups = new LinkedHashSet<>();
        joinedGroups.add(0);
        // 循环将剩余子查询组 join 进结果
        while (joinedGroups.size() < subqueries.size()) {
            boolean found = false;
            for (int g = 1; g < subqueries.size(); g++) {
                if (joinedGroups.contains(g)) continue;
                // 检查组 g 与已连接组之间是否有JOIN条件
                Set<Integer> connectingPair = null;
                List<int[]> condList = null;
                for (Integer jg : joinedGroups) {
                    Set<Integer> key = new LinkedHashSet<>(Arrays.asList(Math.min(jg, g), Math.max(jg, g)));
                    if (joinCondsByGroupPair.containsKey(key)) {
                        connectingPair = key;
                        condList = joinCondsByGroupPair.get(key);
                        break;
                    }
                }
                if (connectingPair == null) {
                    continue; // 没有找到该组与当前集合的连接条件
                }
                // 找到了待JOIN的组 g 及其连接条件 condList
                found = true;
                // 构造 join(g_current, g_new, [keys_left], [keys_right]) 表达式
                String leftExp = currentJoinExp;         // 已有的（已JOIN）部分表达式
                String rightExp = subqueries.get(g);     // 新加入的子查询表达式
                // 为了格式整齐，将左右表达式都括在()中并缩进
                String leftParam = indentAsParam(leftExp, 4);
                String rightParam = indentAsParam(rightExp, 4);
                // 提取左右键列表字符串
                List<String> leftKeys = new ArrayList<>();
                List<String> rightKeys = new ArrayList<>();
                for (int[] cond : condList) {
                    int li = cond[0], ri = cond[1];
                    // 判断 cond[0], cond[1] 属于哪个组，以确保键对应正确方向
                    int groupL = findGroupIndex(groups, li);
                    int groupR = findGroupIndex(groups, ri);
                    String nameL = varList.get(li);
                    String nameR = varList.get(ri);
                    if (groupL == findGroupIndex(groups, g) && groupR != findGroupIndex(groups, g)) {
                        // cond 的第一个变量在新组，第二个变量在已连接组
                        // 交换键顺序，使左边为已连接组的键
                        String tmp = nameL; nameL = nameR; nameR = tmp;
                    }
                    // nameL 对应已连接部分的字段，nameR 对应新组的字段
                    leftKeys.add(nameL);
                    rightKeys.add(nameR);
                }
                // 构造 join 调用的文本
                StringBuilder joinSb = new StringBuilder();
                joinSb.append("join(\n");
                joinSb.append(leftParam).append(",\n");
                joinSb.append(rightParam).append(",\n");
                joinSb.append("    [").append(String.join(", ", leftKeys))
                        .append("], [").append(String.join(", ", rightKeys)).append("]\n");
                joinSb.append(")");
                currentJoinExp = joinSb.toString();
                joinedGroups.add(g);
                break; // 退出 for 循环，重新从头检查下一未连接组
            }
            if (!found) {
                // 没有找到可以连接的组（理论上不应发生，除非有独立子查询无任何JOIN条件）
                break;
            }
        }
//        System.out.println(currentJoinExp);
        // 完成所有子查询JOIN后的表达式在 currentJoinExp 中
        // 替换 RETURN 中的变量引用为 $tuple/var/* 并生成最终查询
        String newReturnClause = replaceReturnVariables(returnClause, varList);
        String optimizedQuery = "for $tuple in " + currentJoinExp + "\nreturn " + newReturnClause;
        return optimizedQuery;
    }

    // 工具方法：找到变量索引所在的组索引（在 groups 列表中的位置）
    private static int findGroupIndex(List<List<Integer>> groups, int varIndex) {
        for (int gi = 0; gi < groups.size(); gi++) {
            if (groups.get(gi).contains(varIndex)) {
                return gi;
            }
        }
        return -1;
    }

    // 工具方法：将一个子查询或JOIN表达式字符串缩进包装成 join 参数形式 "( ... )"
    private static String indentAsParam(String exp, int baseIndent) {
        String[] lines = exp.split("\n");
        String indent = " ".repeat(baseIndent);
        String indentInner = " ".repeat(baseIndent + 4);
        StringBuilder sb = new StringBuilder();
        sb.append(indent);
        for (String line : lines) {
            sb.append(indentInner).append(line).append("\n");
        }
        sb.append(indent);
        // Remove any trailing spaces or newline characters from the StringBuilder
//        while (sb.length() > 0 && (sb.charAt(sb.length() - 1) == ' ' || sb.charAt(sb.length() - 1) == '\n')) {
//            sb.setLength(sb.length() - 1);
//        }
//        sb.append(indent);
        return sb.toString();
    }

    // 工具方法：替换 return 子句中的变量为 $tuple/变量名/* 形式
    private static String replaceReturnVariables(String returnClause, List<String> varList) {
        String result = returnClause;
        // 为避免变量名是其他变量名的前缀，引入正则按单词边界替换，或按长度排序依次替换
        varList.sort((a, b) -> b.length() - a.length()); // 按变量名长度降序
        for (String var : varList) {
            result = result.replaceAll("\\$" + Pattern.quote(var) + "\\b", "\\$tuple/" + var + "/*");
        }
        return result;
    }
}
