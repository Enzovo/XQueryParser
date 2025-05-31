/*
 * @ Class for solving xml data
 * @ Author: Enzo Chen, A69033855
 * @ Author: Weiyu Hao, A16295627
 * @ Topic: XPath Engine for UCSD CSE 232B 2025 winter w/ Alin Deutsch
 * */
import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class XMLDOMParser {
    private static String xml = "";

    public XMLDOMParser(String xml) {
        XMLDOMParser.xml = xml;
    }
    public static Document getTree() {
        try {
            // Load the XML file
            File xmlFile = new File(xml);

            // Configure parser factory to enable DTD validation
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setValidating(true);
            factory.setNamespaceAware(true);
            factory.setIgnoringElementContentWhitespace(true);
            factory.setFeature("http://apache.org/xml/features/nonvalidating/load-dtd-grammar", true);
            factory.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", true);

            // Create a Document Builder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse XML file
            Document document = builder.parse(xmlFile);

            // Normalize the document
            document.getDocumentElement().normalize();
            return document;
//            Element root = document.getDocumentElement();

//            System.out.println(root.getNodeName());

//            return parseElement(document.getDocumentElement());
//            printTree(tree,0);

//            System.out.println(tree);

        } catch (Exception e) {
            e.printStackTrace();
        }
        // Return null if an error occurred
        System.out.println("Error occurred while parsing the XML file.");
        return null;
    }

    /**
     * Parses an XML Element recursively and converts it into a nested Map structure.
     */
    private static Map<String, Object> parseElement(Element element) {
        Map<String, Object> nodeMap = new LinkedHashMap<>();
        NodeList children = element.getChildNodes();

        List<Object> childList = new ArrayList<>();
        for (int i = 0; i < children.getLength(); i++) {
            Node child = children.item(i);

            if (child.getNodeType() == Node.ELEMENT_NODE) {
                Element childElement = (Element) child;
                childList.add(parseElement(childElement));
            } else if (child.getNodeType() == Node.TEXT_NODE) {
                String text = child.getTextContent().trim();
                if (!text.isEmpty()) {
                    childList.add(text);
                }
            }
        }

        if (!childList.isEmpty()) {
            nodeMap.put(element.getNodeName(), childList.size() == 1 ? childList.get(0) : childList);
        } else {
            nodeMap.put(element.getNodeName(), "");
        }

        return nodeMap;
    }
    private static void printTree(Map<String, Object> tree, int depth) {
        for (Map.Entry<String, Object> entry : tree.entrySet()) {
            System.out.println("  ".repeat(depth) + "- " + entry.getKey());
            if (entry.getValue() instanceof Map) {
                printTree((Map<String, Object>) entry.getValue(), depth + 1);
            } else if (entry.getValue() instanceof List) {
                for (Object obj : (List<?>) entry.getValue()) {
                    if (obj instanceof Map) {
                        printTree((Map<String, Object>) obj, depth + 1);
                    } else {
                        System.out.println("  ".repeat(depth + 1) + "Content: " + obj);
                    }
                }
            } else {
                System.out.println("  ".repeat(depth + 1) + "Content: " + entry.getValue());
            }
        }
    }
}
