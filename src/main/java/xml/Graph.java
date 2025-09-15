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

    public void addNode(Node n) {
        nodes.add(n);
    }

    public void addEdge(Edge e) {
        edges.add(e);
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
