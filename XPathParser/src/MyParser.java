/*
 * @ Class for parsing
 * @ Author: Enzo Chen, A69033855
 * @ Author: Weiyu Hao, A16295627
 * @ Topic: XPath Engine for UCSD CSE 232B 2025 winter w/ Alin Deutsch
 * */
import antlr.XPathParser;
import org.antlr.v4.codegen.model.ArgAction;
import org.antlr.v4.codegen.model.Parser;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.Tree;
import org.w3c.dom.*;

import javax.xml.parsers.SAXParser;
import java.util.*;

public class MyParser {
    private ParseTree tree;
    private Document xmlTree;
    private XPathParser parser;
    private List<Node> result = new ArrayList<>();

    private Hashtable<String,List<Node>> variables = new Hashtable<>();

    public MyParser(ParseTree tree, Document xmlTree, XPathParser parser) {
        this.tree = tree;
        this.xmlTree = xmlTree;
        this.parser = parser;
    }

    // milestone2 stuffs
    // makeElem(t,l)?   // makeText(s)?

    int forCount = 0;
    int letCount = 0;
    int ifLet = 0;
    //int ifWhere = 0;
    int outerCount = 0;

    List<Node> resultList = new ArrayList<>();

    // recursion of FLWR
    // Needs a temp Hashtable, replace variables if cond == true
    // 0 for
    public List<Node> FLWRrecursion(ParseTree currTree, Node rootNode, int count, int clause, int ifWhere) {
        List<Node> localList = new ArrayList<>();
//        System.out.println(currTree.getText()+count+clause+ifWhere);
//
//        for (Map.Entry<String, List<Node>> v : variables.entrySet()) {
//            System.out.println(v.getKey());
//            //System.out.println(v.getValue().size());
//        }
        if (clause >= currTree.getChildCount()) {
            System.out.println("Error: clause >= currTree.getChildCount()");
            return new ArrayList<>();
        }
        if (clause == 0) {
            // for ... (let) ... (where) ... return ...
            // $a//SCENE
            // for Var1 in XQ1, Var2 in XQ2
            // for var1 in {for var2 in a/b cond b = 1 return a/b/c} return c/d    a/b/c/d   [c,c,c,c,c] -> [d,d,d,d]
            // for var1 in XQ Let var2 in XQ2 where cond return XQ3
//            System.out.println(currTree.getChild(clause).getChild(count*4+3).getText()+"  "+rootNode);
            // TODO Trying with passing subtree of currTree
//            System.out.println(rootNode.getTextContent());
//            List<Node> currList = XQ(currTree.getChild(clause).getChild(count*4+3),rootNode);
            List<Node> currList = XQ(currTree.getChild(clause).getChild(count*4+3),rootNode);
            if (currList.isEmpty()){
                System.out.println("currList is empty"+getTraceInfo());
                // empty list causes inf recursion
//                exit(0);
            }
//            System.out.println(currList.size());
            for (Node node: currList) {
                List<Node> arr = new ArrayList<>();
                arr.add(node);
//                System.out.println(node.getTextContent());
                // save to temp
                // TODO
//                variables.put(currTree.getChild(clause).getChild(count*4+1).getText(),arr);
                variables.put(currTree.getChild(clause).getChild(count*4+1).getText(),arr);
                if (currTree.getChild(clause).getChild(count*4+1).getText().equals("$a")) {
                    outerCount ++;
//                    System.out.println("NO." + outerCount + " ACT: " + variables.get(currTree.getChild(clause).getChild(count * 4 + 1).getText()).get(0).getTextContent());
                }
                // 跳到下一个for

                if (count+1 < forCount) {
//                    System.out.println(currTree.getText()+"  "+node);
                    localList.addAll(FLWRrecursion(currTree,node,count+1,0,ifWhere));
                }
                else {
                    // 跳到下一个clause F -> LWR
                    localList.addAll(FLWRrecursion(currTree,node,0,clause+1,ifWhere));
                }
//                FLWRrecursion(currTree,node,count+1,0,ifWhere);
//                System.out.println(count+" "+clause);
            }
            return localList;
//            System.out.println(getTraceInfo()+"chulaile!!!"+ifWhere);
//
//
        } else if (clause == 1) {
//            System.out.println(getTraceInfo());
            // for ... (let) ... (where) ... return ...
            if (ifLet == 1) {
//                System.out.println(getTraceInfo());
                if (count >= letCount) {
                    // 跳过let
                    localList.addAll(FLWRrecursion(currTree,rootNode,0,clause+1,ifWhere));
                    return localList;
                }
                // let
//                System.out.println("LINE 65");
                List<Node> currList = XQ(currTree.getChild(clause).getChild(count*4+3),rootNode);

                variables.put(currTree.getChild(clause).getChild(count*4+1).getText(),currList);
                localList.addAll(FLWRrecursion(currTree,rootNode,count + 1, clause,ifWhere));
                return localList;
//                }
            } else if (ifWhere == 1) {
                // where cond
                //ifWhere ++;

                if (cond(currTree.getChild(clause).getChild(1), rootNode)) {
//                    System.out.println("TRUE!"+getTraceInfo());
                    // if true, update variables with temp
                    // resultList.addAll(XQ(currTree.getChild(clause).getChild(1),rootNode));
                    // 跳过where
                    localList.addAll(FLWRrecursion(currTree,rootNode,0, clause+1,ifWhere+1));
                    return localList;
                }else{
                    // cond is false
//                    System.out.println("FALSE"+getTraceInfo());
                    return new ArrayList<>();
//                    exit(0);
                }
            } else {
                // return
                localList.addAll(XQ(currTree.getChild(clause).getChild(1),rootNode));
                return localList;
            }

        } else if (clause == 2) {
            if (ifWhere == 1) {
                // where
//                System.out.println(getTraceInfo());
                if (cond(currTree.getChild(clause).getChild(1), rootNode)) {
                    localList.addAll(FLWRrecursion(currTree,rootNode,count, clause+1,ifWhere+1));

//                    System.out.println("TRUE!"+getTraceInfo());
                    return localList;
                } else{
//                    System.out.println(getTraceInfo());
                    return new ArrayList<>();
                }
            } else{
                // return
                localList.addAll(XQ(currTree.getChild(clause).getChild(1),rootNode));
                return localList;
            }
        } else{
            // return
            localList.addAll(XQ(currTree.getChild(clause).getChild(1),rootNode));
            return localList;
        }
    }


    // FIXME
    public List<Node> XQ(ParseTree currTree, Node rootNode){
        //  and then calls another getChild `
//        System.out.println(getTraceInfo()+" "+currTree.getClass());
//        System.out.println(currTree.getText());
//        System.out.println("--------------");
//        try {
//            System.out.println(variables.get("$a").get(0).getTextContent());
//            System.out.println(variables.get("$sp").get(0).getTextContent());
//            System.out.println(variables.get("$sc").get(0).getTextContent());
//        } catch (Exception e) {
//
//        }
//        System.out.println(currTree.getClass());
//        System.out.println(currTree.getText());
        if (currTree instanceof XPathParser.XQVariableContext){
            // < C(Var) > dict[key] -> value
            // Assume this is the $x for now
//            System.out.println(variables.toString());
            if (variables.get(currTree.getChild(0).getText()) == null) {
                System.out.println("Error: XQVariableContext, No such var");
                return new ArrayList<>();
            }
//            System.out.println(getTraceInfo());
//            if (variables.get("$s1") != null) {
//                variables.get("$s1").forEach(node -> {
//                    for (int i = 0; i < node.getChildNodes().getLength(); i++) {
//                        System.out.println(node.getChildNodes().item(i).getTextContent());
//                    }
//                });
//            }
            return variables.get(currTree.getChild(0).getText());
        } else if (currTree instanceof XPathParser.XQStringConstantContext) {
            // < makeText(StringConstant) >
            ArrayList<Node> arr = new ArrayList<>();
            arr.add(makeText(currTree.getChild(0).getText()));
            return arr;
        } else if (currTree instanceof XPathParser.AbsolutePathContext || currTree instanceof XPathParser.AbsolutePathDoubleSlashContext) {
            // [[ap]]A
//             System.out.println(currTree);
//            System.out.println(currTree.getText()+"  "+rootNode+getTraceInfo());

            return ap(currTree,xmlTree.getDocumentElement());
        } else if (currTree instanceof XPathParser.XQGroupXQContext) {
            // [(XQ1)]X (C)
            // FIXME
            return XQ(currTree.getChild(1),rootNode);
        } else if (currTree instanceof XPathParser.XQUnionXQContext) {
            // [[XQ1]]X (C), [[XQ2]]X (C)
            List<Node> firstList = XQ(currTree.getChild(0),rootNode);
            //Node newRootNode = rootNode.getChildNodes().item(2);
            List<Node> secondLlist = XQ(currTree.getChild(2),rootNode);
            firstList.addAll(secondLlist);
            return firstList;
        } else if (currTree instanceof XPathParser.XQChildPathXQContext) {
            // unique(< m | n ← [[XQ1]]X (C), m ← [[rp]]R(n) >)
//            System.out.println("XQChildPathXQContext"+currTree.getText());
            List<Node> firstList = unique(XQ(currTree.getChild(0),rootNode));
            List<Node> secondList = new ArrayList<>();
            for (Node node : firstList) {
                List<Node> newList = unique(rp(currTree.getChild(2), node));
                secondList.addAll(newList);
            }
            return unique(secondList);
        } else if (currTree instanceof XPathParser.XQDescendantPathXQContext) {
            // unique(< m | n ← [[XQ1]]X (C), m ← [[.//rp]]R(n) >)
            List<Node> firstList = unique(XQ(currTree.getChild(0),rootNode));
            List<Node> secondList = new ArrayList<>();
            for (Node node : firstList) {
                List<Node> newList = unique(rp(currTree.getChild(2), node));
                secondList.addAll(newList);
            }
            //Node newRootNode = rootNode.getChildNodes().item(2);
            secondList.addAll(getDescendants(currTree.getChild(2),rootNode));
            return unique(secondList);
        } else if (currTree instanceof XPathParser.XQElementXQContext) {
            // < makeElem(tagName, [[XQ1]]X (C)) >
            // 〈tagName〉{XQ1}〈/tagName〉
            //  0   1  2 3 4 5
//            System.out.println("jinlaile"+getTraceInfo());
            ArrayList<Node> arr = new ArrayList<>();
            arr.add(makeElement(currTree.getChild(1).getText(),XQ(currTree.getChild(4),rootNode)));
            return arr;
        } else if (currTree instanceof XPathParser.XQForXQContext) {
            // for ... (let) ... (where) ... return ...
            //  0   0.?  1   1.?    2    2.?   3    3.?
            int ifWhere = 0;
//            if (currTree.getChild(0).getChild(3).getText())
            forCount = currTree.getChild(0).getChildCount()/4;
//            System.out.println("ForCount: " + forCount);
            if (currTree.getChild(1) instanceof XPathParser.RuleLetClauseContext) {
                ifLet = 1;
            }
            if (ifLet == 1) {
                letCount = currTree.getChild(1).getChildCount() / 4;
            }
            if (ifLet == 0) {
                if (currTree.getChild(1) instanceof XPathParser.RuleWhereClauseContext) {
                    ifWhere = 1;
                }
            }else{
                if (currTree.getChild(2) instanceof XPathParser.RuleWhereClauseContext) {
                    ifWhere = 1;
                }
            }
            //Hashtable<String,List<Node>> temp = new Hashtable<>();
            List<Node> childResult = FLWRrecursion(currTree,rootNode,0,0,ifWhere);
            //resultList.addAll(childResult);
//            System.out.println("ForCount: " + forCount);
            forCount = 0;
//            letCount = 0;
//            ifWhere = 0;
//            ifLet = 0;
            return childResult;


        } else if (currTree instanceof XPathParser.XQJoinXQContext) {
            // 'join' '(' xq ((comma)* xq)+ (comma)* '[' ID ((comma)*ID)* ']' ((comma)* '[' ID ((comma)*ID)* ']' )+ ')' (comma)*
            List<List<Node>> tuplesList = new ArrayList<>();
            List<String> joinVariables = new ArrayList<>();
            int length = currTree.getChild(0).getChildCount()-2;
            int tuple = 4;
            for (int i=0; i<length; i+=2) {
                if (currTree.getChild(0).getChild(i+2).getClass().toString().split(" ")[1].startsWith("antlr.XPathParser$XQJoin")) {
                    tuplesList.add(XQ(currTree.getChild(0).getChild(i+2),rootNode));
                    i += 1;
                }
                System.out.println(currTree.getChild(0).getChild(i+2).getText() + " - " +getTraceInfo());
                if (!currTree.getChild(0).getChild(i+2).getClass().toString().split(" ")[1].startsWith("antlr.XPathParser$XQFor")) {
                    tuple = i+1;
                    break;
                }

                tuplesList.add(XQ(currTree.getChild(0).getChild(i+2),rootNode));
            }
            for (int i = tuple; i< length; i++) {
                if (currTree.getChild(0).getChild(i).getText().equals(")")){
                    break;
                }
                if (!currTree.getChild(0).getChild(i).getText().equals("[") &&
                    !currTree.getChild(0).getChild(i).getText().equals("]") &&
                    !currTree.getChild(0).getChild(i).getText().equals(",")) {
                    joinVariables.add(currTree.getChild(0).getChild(i).getText());
                }
            }
            System.out.println(joinVariables);
//            System.out.println(tuplesList);
            if (tuplesList.isEmpty()) {
                return new ArrayList<>();
            }
            Map<NodeKey, List<Node>> tupleMaps = new HashMap<>();
            // We build the map for the first list

            for (Node t: tuplesList.get(0)) {
                NodeKey joinKey = buildJoinKey(t, joinVariables);
                if (!tupleMaps.containsKey(joinKey)) {
                    tupleMaps.put(joinKey, new ArrayList<>());
                }
                tupleMaps.get(joinKey).add(t);

            }

            // Then we only want a second map to store the ones from the second list
            Map<NodeKey, List<Node>> tupleMaps2 = new HashMap<>();
            for (Node t: tuplesList.get(1)) {
                NodeKey joinKey = buildJoinKey(t, joinVariables);
                if (!tupleMaps2.containsKey(joinKey)) {
                    tupleMaps2.put(joinKey, new ArrayList<>());
                }
                tupleMaps2.get(joinKey).add(t);
            }

//            System.out.println(tupleMaps);
//            System.out.println(tupleMaps2);
            // Merge tuples with the same key
            List<Node> mergedTuples = new ArrayList<>();
            // Iterate through all keys in tupleMap1
            for (NodeKey key : tupleMaps.keySet()) {
                if (tupleMaps2.containsKey(key)) {
                    List<Node> list1 = tupleMaps.get(key);
                    List<Node> list2 = tupleMaps2.get(key);

                    // Perform Cartesian Product (A length in 1 × A length in 2)
                    for (Node tuple1 : list1) {
                        for (Node tuple2 : list2) {
                            // Merge the two tuples into a new <tuple>
                            Node mergedTuple = mergeNodes(tuple1, tuple2);
                            mergedTuples.add(mergedTuple);
                        }
                    }

                }
            }
            //System.out.println(mergedTuples.get(0).getChildNodes().item(1).getTextContent());
            System.out.println("Returned");
            return mergedTuples;



        } else if (currTree instanceof XPathParser.XQNestedElementXQContext) {
            // <tuple> <a> {XQ} </a> <ta> {XQ} </ta> </tuple>
            Element tuple = xmlTree.createElement(currTree.getChild(1).getText());
            List<Node> tuples = new ArrayList<>();
            List<ParseTree> subTuple = new ArrayList<>();
            for (int i=3; i<currTree.getChildCount()-3; i++) {
                subTuple.add(currTree.getChild(i));
            }
            for (ParseTree child: subTuple){
                String tagName = child.getChild(1).getText();
                tuple.appendChild(makeElement(tagName,XQ(child.getChild(4),rootNode)));
            }
            tuples.add(tuple);
//            System.out.println(tuples);
            return tuples;
        }
        System.out.println("Error: XQ");
        return new ArrayList<>();
    };

    // Check if two lists of Nodes equal
    private static boolean areNodeListsSame(List<Node> list1, List<Node> list2) {
        if (list1 == null || list2 == null) {
            return list1 == list2; // If both are null, return true; if one is null, return false
        }
        if (list1.size() != list2.size()) {
            return false; // Lists must be of the same size
        }

        for (int i = 0; i < list1.size(); i++) {
            if (!list1.get(i).isEqualNode(list2.get(i))) {
                return false; // If any node is not the same, return false
            }
        }

        return true; // All nodes matched
    }

    // Merges multiple tuple nodes into a single tuple
    private Node mergeNodes(Node tuple1, Node tuple2) {
        Element mergedTuple = xmlTree.createElement("tuple");

        // Copy child elements from the first tuple
        for (int i = 0; i < tuple1.getChildNodes().getLength(); i++) {
            Node child = tuple1.getChildNodes().item(i);
            Node copiedNode = xmlTree.importNode(child, true);
            mergedTuple.appendChild(copiedNode);
        }

        // Copy child elements from the second tuple
        for (int i = 0; i < tuple2.getChildNodes().getLength(); i++) {
            Node child = tuple2.getChildNodes().item(i);
            Node copiedNode = xmlTree.importNode(child, true);
            mergedTuple.appendChild(copiedNode);
        }

        return mergedTuple;
    }
    // Builds a unique join key for multiple variables
    private NodeKey buildJoinKey(Node tuple, List<String> joinVariables) {
        List<Node> nodes = new ArrayList<>();
        for (int i = 0; i < tuple.getChildNodes().getLength(); i++) {
            for (String var : joinVariables) {
                if (tuple.getChildNodes().item(i).getNodeName().equals(var)) {
                    Node value = extractTagValue(tuple, var);
                    nodes.add(value);
                }
            }
        }
        return new NodeKey(nodes);
    }
    // Extracts a tag value from a tuple
    private Node extractTagValue(Node tuple, String tagName) {
        for (int i = 0; i < tuple.getChildNodes().getLength(); i++) {
            Node child = tuple.getChildNodes().item(i);
//            System.out.println(child.getTextContent());
            if (child.getNodeName().equals(tagName)) {
                //System.out.println(child.getChildNodes().item(0));
                return child.getChildNodes().item(0);
            }
        }
        return null;
    }

    int debugCounter = 0;
    public boolean cond(ParseTree currTree, Node rootNode){

        if (currTree instanceof XPathParser.CondEqualContext || currTree instanceof XPathParser.CondEqContext) {
            // cond = cond, cond eq cond
//            System.out.println("----COND----");
//            System.out.println(variables.toString());
//            System.out.println(currTree.getChild(0).getText());
//            System.out.println(currTree.getChild(2).getText());
//            if (debugCounter == 314) {
//                System.out.println("DEBUG");
//            }
            List<Node> firstList = XQ(currTree.getChild(0), rootNode);
            List<Node> secondList = XQ(currTree.getChild(2), rootNode);
//            System.out.println(getTraceInfo()+firstList+"             second:"+secondList);
//            System.out.println(firstList);
//            System.out.println(secondList);
//            System.out.println("----COND----");
//            debugCounter ++;
//            System.out.println(firstList.size());
            boolean flag = false;
            for (Node node1 : firstList) {
                for (Node node2 : secondList) {
                    List<Node> arr1 = new ArrayList<>();
                    List<Node> arr2 = new ArrayList<>();
                    arr1.add(node1);
                    arr2.add(node2);
                    if (checkEqual(arr1,arr2)) {
                        flag = true;
                        break;
                    }
                }
                if (flag){
                    break;
                }
            }
//            return checkEqual(firstList,secondList);
            return flag;
//            if (checkEqual(firstList,secondList)) {
//                return true;
//            };
//            return false;

        }else if (currTree instanceof XPathParser.CondIsContext || currTree instanceof XPathParser.CondDoubleEqualContext) {
            // cond == cond, cond is cond
            List<Node> firstList = XQ(currTree.getChild(0), rootNode);
            List<Node> secondList = XQ(currTree.getChild(2), rootNode);
            for (Node node1 : firstList) {
                for (Node node2 : secondList) {
                    if (node1.isSameNode(node2)) {
                        return true;
                    }
                }

            }
            return false;
        } else if (currTree instanceof XPathParser.CondAndContext) {
            // cond and cond
            return cond(currTree.getChild(0), rootNode) && cond(currTree.getChild(2), rootNode);

        } else if (currTree instanceof XPathParser.CondOrContext) {
            // cond or cond
            return cond(currTree.getChild(0), rootNode) || cond(currTree.getChild(2), rootNode);

        } else if (currTree instanceof XPathParser.CondNotContext) {
            // not cond
            return !cond(currTree.getChild(1), rootNode);

        } else if (currTree instanceof XPathParser.GroupCondContext) {
            // (cond)
            return cond(currTree.getChild(1), rootNode);
        } else if (currTree instanceof XPathParser.CondEmptyContext) {
            // empty(XQ)
            return XQ(currTree.getChild(2), rootNode).isEmpty();
        } else if (currTree instanceof XPathParser.CondSomeContext) {
            // some Var1 in XQ1, . . . , Varn in XQn satisfies Cond
//            for $a in document("j_caesar.xml")//ACT/SCENE
//            some $b in $a/TITLE, $c in $a/TITLE satisfies $b/text() = "SCENE II.  A public place." or $c/text() = "SCENE II.  A public place."
//            return <who>{$a}</who>

            int clauseCount = (currTree.getChildCount() - 2)/4;
            int conditionIdx = currTree.getChildCount() - 1;
            for (int i = 0; i < clauseCount; i++) {
                List<Node> currList = XQ(currTree.getChild(i*4+3),rootNode);
                // change to directly add to variables
//                variables.put(currTree.getChild(i*4+1).getText(),currList);
                for (Node node: currList) {
                    List<Node> arr = new ArrayList<>();
                    arr.add(node);
                    variables.put(currTree.getChild(i*4+1).getText(),arr);
                    if (cond(currTree.getChild(conditionIdx), rootNode)){
                        return true;
                    }
//                    System.out.println(currTree.getChild(conditionIdx).getText());

                }
            }
            return false;

//            return cond(currTree.getChild(conditionIdx), rootNode);
//            if (!cond(currTree.getChild(conditionIdx),rootNode)) {
//                return false;
//            }
//            return true;
        }

        System.out.println("Error: cond");
        return false;
    };


    // 开始帕丝！
    public List<Node> parseIt() {
//        System.out.println(tree.getClass().toString());
//        System.out.println(tree.getChildCount());
        //System.out.println(tree.getClass().toString().split(" ")[1]);
        // 递归解
        Node rootNode = xmlTree.getDocumentElement();
//        System.out.println(tree);
        ParseTree child = tree.getChild(0);
//        System.out.println(child.getChild(3).getChild(0).getChild(2).getChild(0).getChild(3).getChild(5).getChild(0).getText());
//        System.out.println(rootNode.getNodeName());

//        System.out.println(tree.getClass().toString().split(" ")[1]);
        if (tree.getClass().toString().split(" ")[1].startsWith("antlr.XPathParser$XQ")) {
            // {currTree.getChild(4)}, main part starts with 4
            if (child.getText().startsWith("<")){
                result = XQ(tree.getChild(4),rootNode);
            }
            else {
                result = XQ(tree, rootNode);
            }
        }
        else if (child.getText().equals("document") || child.getText().equals("doc")) {
            result = ap(tree,rootNode);
            // set i
        } else
        {
            // Might not be called
            rp(tree,rootNode);
        };

        // 开始解析XML
//        System.out.println(xmlTree);
//        Element root = xmlTree.getDocumentElement();
//        NodeList children = root.getChildNodes();
//        for (int i = 0; i < children.getLength(); i++) {
//            Node child = children.item(i);
//            if (child.getNodeType() == Node.ELEMENT_NODE) {
//                Element element = (Element) child;
//                System.out.println(element.getTagName());
//            }
//        }

        // 开始分布解析


        return result;
    }

    public Node makeText(String str) {
        return xmlTree.createTextNode(str.substring(1, str.length() - 1));
    }

    public Node makeElement(String tagName, List<Node> nodeList) {
        // create an element <tagName> with children of nodeList
        Element newElement = xmlTree.createElement(tagName);
        for (Node node : nodeList) {
            Node copiedNode = node.cloneNode(true);
            newElement.appendChild(copiedNode);
        }

        return newElement;
    }

//    public List<Node> makeTupleElement(ParseTree currTree) {
//
//    }

    public List<Node> unique(List<Node> list) {
//        List<Node> uniqueList = new ArrayList<>();
//        for (Node node : list) {
//            // Check if node is already in uniqueList by equals comparison
//            boolean found = false;
//            for (Node uniqueNode : uniqueList) {
//                if (node.equals(uniqueNode) || node.getTextContent().equals(uniqueNode.getTextContent())) {
//                    found = true;
//                    break;
//                }
//            }
//
//            if (!found) {
//                uniqueList.add(node);
//            }
//        }
//        return uniqueList;
        Set<Node> visit = new HashSet<>();
        List<Node> uniquList = new ArrayList<>();
        for (Node node: list) {
            if (!visit.contains(node)){
                uniquList.add(node);
                visit.add(node);
            }

        }
        return uniquList;
    }

    /**
     * 获取节点 node 的所有后代节点。用于 ap//rp
     *
     * @param currTree 起始节点
     * @param rootNode
     * @return 后代节点列表
     */
    public List<Node> getDescendants(ParseTree currTree, Node rootNode) {
//        System.out.println("####");
//        System.out.println(currTree.getClass());
//        System.out.println(currTree.getText());
//        System.out.println(currTree.getChildCount());
//        System.out.println(rootNode.getNodeName());
        List<Node> descendants = new ArrayList<>();

        try {
            descendants.addAll(unique(rp(currTree, rootNode)));
        } catch (Exception e) {
            System.out.println("Error in getDescendants, rp return null");
        }
        NodeList children = rootNode.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            Node child = children.item(i);
            if (child != null && child.getNodeType() == Node.ELEMENT_NODE) {
                //System.out.println(child);
                descendants.addAll(getDescendants(currTree,child));
                //System.out.println(descendants);
            }
        }

        return unique(descendants);
    }


    public List<Node> ap(ParseTree currTree, Node rootNode) {
//        System.out.println(currTree.getText()+getTraceInfo());
        if (currTree instanceof XPathParser.AbsolutePathContext){
            // ap/rp
//            List<Node> newRootNode = getNewXMLRoot(rootNode, currTree.getText());
//            System.out.println("+++++++++++++++++"+currTree.getChild(5).getText());
            return rp(currTree.getChild(5),rootNode);
        }
        else if (currTree instanceof XPathParser.AbsolutePathDoubleSlashContext) {
            // ap//rp

            return getDescendants(currTree.getChild(5),rootNode);
        }
        System.out.println("Error: happens in ap");
        return new ArrayList<>();
    }

    /**
     * [[rp]]R(n): 从节点 node 出发，沿着相对路径 relativePath 导航，
     * 返回所到达的（元素或文本）节点的列表。
     *
     * @param currTree         起始节点（一个元素节点）
     * @param rootNode 相对路径字符串（XPath表达式）
     * @return 节点列表
     */
    public List<Node> rp(ParseTree currTree, Node rootNode) {
//        System.out.println("IN rp:");
//        System.out.println(currTree.getText());
        if (currTree instanceof XPathParser.TagContext){
            String tagName = currTree.getText();
            if (tagName.equals(rootNode.getNodeName())) {
                List<Node> arr = new ArrayList<>();
                arr.add(rootNode);
                return arr;
            }
//            System.out.println(tagName);
            if (tagName.equals(rootNode.getNodeName())){
                ArrayList<Node> arr = new ArrayList<>();
                arr.add(rootNode);
                return arr;
            }
            NodeList children = rootNode.getChildNodes();
            List<Node> childList = new ArrayList<>();
            for (int i = 0; i<children.getLength(); i++) {
                if (children.item(i).getNodeType() == Node.ELEMENT_NODE) {
                    childList.add(children.item(i));
                }
            }

            List<Node> output = new ArrayList<>();
            if (childList.isEmpty()) {
//                System.out.println("Error: childList is empty in rp");
                return new ArrayList<>();
            }
            try {
                for (Node c : childList) {
                    //System.out.println(c.getNodeName());
                    if (c.getNodeName().equals(tagName)) {

                        output.add(c);
                    }
                }
            } catch (Exception e) {
                System.out.println("Error in rp");
            }
//            System.out.println(output);
            return output;
        }
        else if (currTree instanceof XPathParser.WildcardContext)
        {
            NodeList children = rootNode.getChildNodes();
            List<Node> childList = new ArrayList<>();
            for (int i = 0; i<children.getLength(); i++) {
//                if (children.item(i).getNodeType() == Node.ELEMENT_NODE ||
//                        children.item(i).getNodeType() == Node.TEXT_NODE ||
//                        children.item(i).getNodeType() == Node.ATTRIBUTE_NODE) {
                childList.add(children.item(i));
//                }
            }
            return childList;
        }
        else if (currTree instanceof XPathParser.SelfContext)
        {
            ArrayList<Node> arr = new ArrayList<>();
            arr.add(rootNode);
            return arr;
        }
        else if (currTree instanceof XPathParser.ParentContext)
        {
            ArrayList<Node> arr = new ArrayList<>();
            arr.add(rootNode.getParentNode());
            return arr;
        }
        else if (currTree instanceof XPathParser.TextFunctionContext)
        {
            NodeList children = rootNode.getChildNodes();
            for (int i=0; i<children.getLength();i++)
            {
                if (children.item(i).getNodeType() == Node.TEXT_NODE)
                {
//                    System.out.println(children.item(i));
                    ArrayList<Node> arr = new ArrayList<>();
                    arr.add(children.item(i));
                    return arr;
                }
            }
            return new ArrayList<>(); // No text found
        }
        else if (currTree instanceof XPathParser.AttributeContext)
        {
            // [@attName]]R(n)
            // @PLAY
            // 0 1
            ArrayList<Node> arr = new ArrayList<>();
            arr.add(rootNode.getAttributes().getNamedItem(currTree.getChild( 1).getText()));
            return arr;
        }
        else if (currTree instanceof XPathParser.GroupContext)
        {
            // [(rp)]R(n) -> [rp]R(n)
            // get rid of ()
            return rp(currTree.getChild(1),rootNode);
        }
        else if (currTree instanceof XPathParser.ChildPathContext)
        {
            //[rp1/rp2]R(n) = unique(< y | x ← [[rp1]]R(n), y ← [[rp2]]R(x) >)
            //  0 1 2
            // rootNode updated by firstList.get(i)
//            System.out.println(getTraceInfo()+currTree.getChild(0).getText());
//            if (currTree.getChild(0).getText().equals(rootNode.getNodeName())) {
//
//            }
            List<Node> firstList = unique(rp(currTree.getChild(0),rootNode));
            List<Node> secondList = new ArrayList<>();
            for (int i=0;i<firstList.size();i++)
            {
                List<Node> newList = unique(rp(currTree.getChild(2),firstList.get(i)));
                secondList.addAll(newList);
            }
            // Convert set back to list
            return unique(secondList);
        }
        else if (currTree instanceof XPathParser.DescendantPathContext)
        {
            // [rp1//rp2]]R(n) = unique([[rp1/rp2]]R(n), [[rp1/ ∗ //rp2]]R(n))
            // rp / rp first
//            System.out.println("jinlai"+currTree.getText()+rootNode);
            List<Node> firstList = unique(rp(currTree.getChild(0),rootNode));
            List<Node> secondList = new ArrayList<>();
            for (int i=0;i<firstList.size();i++)
            {
                List<Node> newList = unique(rp(currTree.getChild(2),firstList.get(i)));
                secondList.addAll(newList);
            }
            // Convert set back to list

//            System.out.println(secondList.size());
            secondList.addAll(getDescendants(currTree.getChild(2),rootNode));
            return unique(secondList);
//            List<Node> orderedDescendants = getDescendants(currTree.getChild(2), rootNode);
//            secondList.addAll(orderedDescendants);
//            return secondList;  // Preserves original XML order
        }
        else if (currTree instanceof XPathParser.FilteredPathContext)
        {
            // [rp[f ]]]R(n) = < x | x ← [[rp]]R(n), [[f ]]F (x) >
//            System.out.println(currTree.getChild(0).getText());
            // update rootNode
            String[] paths = currTree.getChild(0).getText().split("//+|/");
            paths = Arrays.copyOf(paths, paths.length - 1);
//            System.out.println(Arrays.toString(paths));
            Node newrootNode = rootNode;
            NodeList children = null;
            for (String path:paths) {
                children = newrootNode.getChildNodes();
                for (int i = 0; i < children.getLength(); i++) {
                    if (children.item(i).getNodeName().equals(path)) {
                        newrootNode = children.item(i);
                        break;
                    }
                }
                if (newrootNode == null) {
                    System.out.println("Error: rootNode is null");
                    return new ArrayList<>();
                }
            }
//            System.out.println("++"+newrootNode+currTree.getChild(0).getText());

            // 先找到所有的nodes，然后每一个调用一次filter，满足条件的加入结果中
            // 这个没什么问题了
//            System.out.println(currTree.getChild(2).getText());
//            List<Node> candidates = rp(currTree.getChild(0).getChild(currTree.getChild(0).getChildCount()-1),newrootNode);
            List<Node> candidates = rp(currTree.getChild(0),rootNode);
//            System.out.println(candidates);
            List<Node> output = new ArrayList<>();
            if (candidates == null) {
                System.out.println("Error: candidates is null");
                return new ArrayList<>();
            }
            // 对所有的nodes，看它是否满足filter的要求
            try {
                for (Node c : candidates) {
                    if (f(currTree.getChild(2), c)) {
//                    System.out.println(c.getNodeName());
                        output.add(c);
                    }
                }
            } catch (Exception e) {
                System.out.println("Error in rp");
            }
//            System.out.println(output.size());
            return output;

        }
        else if (currTree instanceof XPathParser.UnionPathContext)
        {
            // [rp1, rp2]]R(n) = [[rp1]]R(n), [[rp2]]R(n)
            List<Node> firstList = rp(currTree.getChild(0),rootNode);
            List<Node> unionList = rp(currTree.getChild(2),rootNode);
            unionList.addAll(firstList);
            return unionList;
        }
        System.out.println("Error: Nothing match in rp");
//        System.out.println(currTree.getClass());
        // Might cause error
        return null;
    }


    /**
     * [[f]]F(n): 判断过滤条件 filter 是否在节点 node 上成立。
     *
     * @param currTree   节点
     * @param rootNode 过滤表达式
     * @return 如果过滤条件成立，则返回 true；否则返回 false
     */
    public boolean f(ParseTree currTree, Node rootNode) {
        // rp

//        System.out.println(currTree.getChild(0).getText());
//        System.out.println(rootNode.getFirstChild());
        if (currTree instanceof XPathParser.StringEqualFilterContext) {
            // rp = StringConstant
//            System.out.println(currTree.getChild(0).getText());
//            List<Node> nodes = rp(currTree.getChild(0), rootNode);
//            System.out.println("jinlai");
            String stringConstant = currTree.getChild(2).getText().replace("\"", "").replace("'", ""); // Strip quotes

            List<Node> compareString = rp(currTree.getChild(0),rootNode);
//            System.out.println(compareString);
            if (compareString == null) {
//                System.out.println("Error: compareString is null");
                return false;
            }
            for (Node node : compareString) {
                if (rootNode != null && node.getTextContent().equals(stringConstant)) {
                    return true;
                }
            }
            return false;
        } else if (currTree instanceof XPathParser.FilterRpContext)
        {
//            System.out.println(currTree.getText()+rootNode);
//            List<Node> temp = rp(currTree, rootNode);
//            System.out.println(currTree.getChild(0).getText());
//            System.out.println(!(rp(currTree.getChild(0), rootNode) == null));
            return !(rp(currTree.getChild(0), rootNode).isEmpty());
        } else if (currTree instanceof XPathParser.EqualFilterContext || currTree instanceof XPathParser.EqFilterContext)
        {
            // [rp = rp]F(n) = [[rp1]]R(n) = [[rp2]]
            List<Node> firstList = rp(currTree.getChild(0),rootNode);
            List<Node> secondList = rp(currTree.getChild(2),rootNode);
            boolean flag = false;
            for (Node node1 : firstList) {
                for (Node node2 : secondList) {
                    List<Node> arr1 = new ArrayList<>();
                    List<Node> arr2 = new ArrayList<>();
                    arr1.add(node1);
                    arr2.add(node2);
                    if (checkEqual(arr1,arr2)) {
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    break;
                }
            }
            return flag;

        } else if (currTree instanceof XPathParser.IsFilterContext || currTree instanceof XPathParser.DoubleEqualFilterContext)
        {
//            System.out.println(currTree.getChild(2).getText());
            // [rp is rp]F(n) == [[rp1]]R(n) == [[rp2]]R(n)
            List<Node> firstList = rp(currTree.getChild(0),rootNode);
            List<Node> secondList = rp(currTree.getChild(2),rootNode);
//            List<Node> tempList = rp(currTree.getChild(0),rootNode);
//            System.out.println(firstList.get(0) == tempList.get(0));
            for (Node node1 : firstList) {
                for (Node node2 : secondList) {
                    // This checks structural equality, i.e., same element name,
                    // attributes, child nodes, etc.
                    if (node1.isSameNode(node2)) {
//                    if (node1 == node2) {
                        return true;
                    }
                }
            }
            return false;
        } else if (currTree instanceof XPathParser.GroupFilterContext)
        {
            // [rp/..]F(n) = [[rp]]R(n) = [[..]]R(n)
//            System.out.println(currTree.getChild(1).getText());
            // 去掉括号后，交给StringEqualFilterContext处理
            return f(currTree.getChild(1),rootNode);
        } else if (currTree instanceof XPathParser.AndFilterContext)
        {
            // [f and f]F(n) = [[f1]]F(n) and [[f2]]F(n)
            return f(currTree.getChild(0),rootNode) && f(currTree.getChild(2),rootNode);
        } else if (currTree instanceof XPathParser.OrFilterContext)
        {
            // [f or f]F(n) = [[f1]]F(n) or [[f2]]F(n)
            return f(currTree.getChild(0),rootNode) || f(currTree.getChild(2),rootNode);
        } else if (currTree instanceof XPathParser.NotFilterContext)
        {
            // [not f]F(n) = not [[f]]F(n)
//            System.out.println(currTree.getChild(1).getText());
            return !f(currTree.getChild(1),rootNode);
        }

        System.out.println("Error: f");
        return false;
    }

    public boolean checkEqual(List<Node> firstList, List<Node> secondList) {
        if (firstList.size() != secondList.size()) {
//            System.out.println("firtList.size()="+firstList.size()+"  secondList.size()="+secondList.size());
            return false;
        }
        if (firstList.isEmpty() && secondList.isEmpty()) {
            return true;
        }

        boolean flag = false;
        for (int i = 0; i<firstList.size();i++)
        {
            if (!(firstList.get(i).getNodeName().equals(secondList.get(i).getNodeName())) ||
                    !(firstList.get(i).getTextContent().equals(secondList.get(i).getTextContent()))){
//                System.out.println(firstList.get(i).getTextContent()+ "              second: "+secondList.get(i).getTextContent());
                return false;
            }
            List<Node> firstChild = new ArrayList<>();
            for (int j = 0; j < firstList.get(i).getChildNodes().getLength(); j++) {
                firstChild.add(firstList.get(i).getChildNodes().item(j));
            }
            List<Node> secondChild = new ArrayList<>();
            for (int j = 0; j < secondList.get(i).getChildNodes().getLength(); j++) {
                secondChild.add(secondList.get(i).getChildNodes().item(j));
            }
            flag = checkEqual(firstChild,secondChild);
        }
//        System.out.println(getTraceInfo());
        return flag;
    }

    // debug use
    public static String getTraceInfo() {
        StringBuffer sb = new StringBuffer();
        StackTraceElement[] stacks = new Throwable().getStackTrace();
        int stacksLen = stacks.length;
        sb.append("class: ").append(stacks[1].getClassName())
                .append("; method: ").append(stacks[1].getMethodName())
                .append("; number: ").append(stacks[1].getLineNumber());
        return sb.toString();
    }

}
