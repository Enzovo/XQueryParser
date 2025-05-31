### Main.java, class with main function
### Author: Enzo Chen, A69033855
### Author: Weiyu Hao, A16295627
#### Topic: XPath Engine for UCSD CSE 232B 2025 winter w/ Alin Deutsch

This main class now accepts:
args[0] -> j_caesar.xml (the input XML file)
args[1] -> q1.txt (first query file)
args[2] -> q1.xml (first output file)
args[3] -> q2.txt (second query file)
args[4] -> q2.xml (second output file)
... and so on.

The XPath query results (a list of nodes) are wrapped under a single <RESULT> element
in the output XML file.  

Such as:  
cd XPathParser/src(if not in src folder)  
java -cp antlr-4.13.2-complete.jar org.antlr.v4.Tool Exp.g4  
javac -cp ".;antlr-4.13.2-complete.jar" *.java(for windows) OR javac -cp .:antlr-4.13.2-complete.jar *.java (for mac)  
java -cp ".;antlr-4.13.2-complete.jar" Main "data.xml" "query.txt" "result.xml" (for windows) OR java -cp .:antlr-4.13.2-complete.jar Main "data.xml" "query.txt" "result.xml" (for mac)  
