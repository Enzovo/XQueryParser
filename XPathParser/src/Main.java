//import XPathLexer;
import antlr.XPathParser;
import antlr.XPathLexer;


import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.StringWriter;
import java.util.List;

import static java.lang.System.exit;

public class Main {
    public static void main(String[] args) throws Exception {
        // We require at least 3 arguments and then every query file must have a corresponding output file.
        if(args.length < 4 || ((args.length - 1) % 3 != 0)) {
            System.err.println("Usage: java -cp lib/* main.Main <input xml file> " +
                    "<query1 file> <rewrite1 file> <output1 file> [<query2 file> <rewrite1 file> <output2 file> ...]");
            exit(1);
        }

        // The first argument is the input XML file (j_caesar.xml)
        String xmlFilePath = args[0];

        // Parse the XML input file once.
        XMLDOMParser xmlDomParser = new XMLDOMParser(xmlFilePath);
        Document xmlTree = xmlDomParser.getTree();
//        System.out.println("===================================");
//        System.out.println(xmlTree.getDocumentElement().getNodeName() + " " + xmlTree.getDocumentElement().getTextContent() );
//        System.out.println("===================================");

        // Process each query file (with its corresponding output file)
        for (int i = 1; i < args.length; i += 3) {
            String queryFilePath = args[i];
            String rewriteFilePath = args[i + 1];
            String outputFilePath = args[i + 2];

            // TODO: Implement the rewrite method.
            // 1. Parse the rewrite file using ANTLR.
//            RewriteLexer rewriteLexer = new RewriteLexer(new ANTLRFileStream(queryFilePath));
//            RewriteParser rewriteParser = new RewriteParser(new CommonTokenStream(rewriteLexer));
//            ParseTree rewriteTree = rewriteParser.xQuery();
            // 2. Parse
            QueryRewriter rewriter = new QueryRewriter();
            rewriter.rewrite(rewriteFilePath, queryFilePath);


            // 1. Parse the query file using ANTLR.
            XPathLexer lexer = new XPathLexer(new ANTLRFileStream(rewriteFilePath));
            XPathParser parser = new XPathParser(new CommonTokenStream(lexer));

            ParseTree tree = parser.xq();

            // debug
            System.out.println("==========================");
            System.out.println(tree.toStringTree(parser));
            System.out.println(tree.getChildCount());
            System.out.println(tree.getClass());
            System.out.println("==========================");
            // exit(0);

            // 2. Use your XPath engine (MyParser) to evaluate the query on the XML tree.
            MyParser myParser = new MyParser(tree, xmlTree, parser);
            List<Node> resultNodes = myParser.parseIt();

            // 3. Create a new output Document that will hold the results.
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document resultDocument = dBuilder.newDocument();

            // Create the root element with the give tagname

//            Element outerResult = resultDocument.createElement("result");
//            resultDocument.appendChild(outerResult);

//            System.out.println(resultNodes.size());
            Element innerRoot;
            try {
                innerRoot = resultDocument.createElement(tree.getChild(1).getText());
            } catch (DOMException e) {
                System.out.println("Error: " + e.getMessage());
                innerRoot = resultDocument.createElement("RESULT");
            }

//            rootElement = resultDocument.createElement("RESULT");
//            outerResult.appendChild(innerRoot);
            resultDocument.appendChild(innerRoot);
//            System.out.println(rootElement);
//            System.out.println(resultDocument);



            // Import each node from your result list into the new document and append it under <RESULT>.
            if (!resultNodes.isEmpty()) {
                for (Node node : resultNodes) {
                    Node importedNode = resultDocument.importNode(node, true);
                    innerRoot.appendChild(importedNode);
                }
            }else{
                innerRoot.appendChild(resultDocument.createTextNode(""));
            }
//            System.out.println(rootElement);

            // 4. Write the resultDocument to the specified output file.
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            // Set the indentation amount (works with most XSLT processors)
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");

            DOMSource source = new DOMSource(resultDocument);
            StreamResult streamResult = new StreamResult(new File(outputFilePath));
            transformer.transform(source, streamResult);
            System.out.println("Output file written to: " + outputFilePath);
        }
    }





    // (Optional) Helper method to convert a Node to a String. Useful for debugging.
    public static String nodeToString(Node node) {
        try {
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            StringWriter sw = new StringWriter();
            StreamResult result = new StreamResult(sw);
            transformer.transform(new DOMSource(node), result);
            return sw.toString();
        } catch (TransformerException e) {
            e.printStackTrace();
            return "";
        }
    }

    private static void printResult(List<Node> result) {
        for (Node node : result) {
            String xmlString = nodeToString(node);
            System.out.print(xmlString);
        }
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
