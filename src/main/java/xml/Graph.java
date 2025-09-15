package xml;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Graph {
    private String id;
    private List<Node> nodes;
    private List<Edge> edges;

    public Graph(String id) {
        this.id = id;
        nodes =  new ArrayList<>();
        edges = new ArrayList<>();
    }

    /**
     * Adds a node to the graph.
     * @param n The node to be added.
     */
    public void addNode(Node n) {
        nodes.add(n);
    }

    public void addEdge(Edge e) {
        edges.add(e);
    }

    /**
     * Get the node with the given id.
     * @param id The id of the node to find
     * @return The node with the given ID.
     */
    public Node getNodeById(String id) {
        for (Node n : nodes) {
            if (n.getId().equals(id)) {
                return n;
            }
        }
        throw new RuntimeException("No node with id: " + id);
    }

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder("Graph ")
                .append(id).append(": \nNodes: ");
        result.append(nodes.stream()
                .map(Node::toString)
                .collect(Collectors.joining(", ")));
        result.append("\nEdges: ");
        for (Edge e : edges){
            result.append(e.toString()).append('\n');
        }
        return result.toString();
    }
}
