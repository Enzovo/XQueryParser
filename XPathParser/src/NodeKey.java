import org.w3c.dom.Node;
import java.util.*;
public class NodeKey {
    private final List<String> nodeIdentifiers; // Stores normalized node representations

    public NodeKey(List<Node> nodes) {
        this.nodeIdentifiers = new ArrayList<>();
        for (Node node : nodes) {
            this.nodeIdentifiers.add(normalizeNode(node)); // Store normalized representation
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        NodeKey other = (NodeKey) obj;
        return Objects.equals(this.nodeIdentifiers, other.nodeIdentifiers); // Compare normalized values
    }

    @Override
    public int hashCode() {
        return Objects.hash(nodeIdentifiers); // Generate hash from normalized values
    }

    private String normalizeNode(Node node) {
        if (node == null) return "";
        return node.getNodeName() + "=" + node.getTextContent().trim(); // Create a unique identifier
    }


}
