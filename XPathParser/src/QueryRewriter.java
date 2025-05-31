import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QueryRewriter {

    // 保存每个变量的分组信息，"L" 表示左组，"R" 表示右组
//    private Map<String, String> varGroupMap = new HashMap<>();
//    // 保存从 where 子句中提取的 join 条件左右变量（不带 $ 符号）
//    private String leftJoinVar = "";
//    private String rightJoinVar = "";

    /**
     * rewrite 方法：
     * @param rewriteFilePath 输出文件路径
     * @param queryFilePath   输入查询文件路径（要求包含 for、where、return 三部分）
     */
    public void rewrite(String rewriteFilePath, String queryFilePath) {
        String fileContent = "";
        try {
            fileContent = Files.readString(Paths.get(queryFilePath));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Error reading the query file: " + e.getMessage());
        }
        XQueryJoinOptimizer optimizer = new XQueryJoinOptimizer();
        String result = optimizer.optimizeQuery(fileContent);

//        // 提取 for、where、return 三部分（假定这些关键字存在且格式正确）
//        String forPart = fileContent.substring(fileContent.indexOf("for"), fileContent.indexOf("where")).trim();
//        String wherePart = fileContent.substring(fileContent.indexOf("where"), fileContent.indexOf("return")).trim();
//        String returnPart = fileContent.substring(fileContent.indexOf("return")).trim();
//
//        String newFor = handleFor(forPart);
//        String newWhere = handleWhere(wherePart);
//        String newReturn = handleReturn(returnPart);
//
//        String result = newFor + "\n" + newWhere + "\n" + newReturn;

        try {
            File file = new File(rewriteFilePath);
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();
            try (FileWriter writer = new FileWriter(file)) {
                writer.write(result);
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Error writing to rewrite file: " + e.getMessage());
        }
    }

    /**
     * 处理 where 部分：
     * 提取 join 条件（形如 "$x eq $y" 或 "$x = $y"）中的左右变量，
     * 并返回空字符串（假定 where 部分仅用于连接条件）。
     */
//    private String handleWhere(String wherePart) {
//        Pattern joinPattern = Pattern.compile("\\$(\\w+)\\s*(?:eq|=)\\s*\\$(\\w+)");
//        Matcher m = joinPattern.matcher(wherePart);
//        if (m.find()) {
//            leftJoinVar = m.group(1);
//            rightJoinVar = m.group(2);
//            // 返回空字符串，假定 where 中只有连接条件
//            return "";
//        }
//        return wherePart;
//    }
//
//    private String handleFor(String forPart) {
//       return "";
//    }

//    private String handleReturn(String returnPart) {
//        String modifiedReturn = returnPart;
//        // 按变量名长度从长到短替换，避免部分匹配问题
//        List<String> vars = new ArrayList<>(varGroupMap.keySet());
//        vars.sort((a, b) -> b.length() - a.length());
//        for (String var : vars) {
//            modifiedReturn = modifiedReturn.replaceAll("\\$" + var + "\\b", "\\$tuple/" + var + "/*");
//        }
//        return modifiedReturn;
//    }

}
