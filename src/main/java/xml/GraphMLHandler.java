package xml;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class GraphMLHandler extends DefaultHandler {
    private Graph graph;
    private List<Key> keys = new ArrayList<>();
    private Key currentKey;
    private StringBuilder currentText;

    @Override
    public void startDocument() {
        System.out.println("Start Document.");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if (qName.equals("graph")) {
            String id = attributes.getValue("id");
            graph = new Graph(id);
        }
        if (qName.equals("node")) {
            String id = attributes.getValue("id");
            Node n = new Node(id);
            graph.addNode(n);
        }
        if (qName.equals("edge")) {
            String source = attributes.getValue("source");
            String target = attributes.getValue("target");
            Node sourceNode = graph.getNodeById(source);
            Node targetNode = graph.getNodeById(target);
            Edge e = new Edge(sourceNode, targetNode);
            graph.addEdge(e);
        }
        if (qName.equals("key")) {
            String id = attributes.getValue("id");
            String whatFor = attributes.getValue("for");
            String attrName = attributes.getValue("attr.name");
            String attrType = attributes.getValue("attr.type");
            currentKey = new Key(id, whatFor, attrName, attrType);
            keys.add(currentKey);
        }
        if (qName.equals("default") && currentKey != null) {
            currentText = new StringBuilder();
        }
        System.out.println("Start Element : " + qName);
        System.out.println("Attributes: ");
        for (int i = 0; i < attributes.getLength(); i++) {
            System.out.println("- QName: " + attributes.getQName(i));
            System.out.println("- Value: " + attributes.getValue(i));
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        // Append characters to the StringBuilder, we see this after the default start element.
        if (currentText != null) {
            currentText.append(ch, start, length);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        System.out.println("End Element: " + qName);
        // We finished with the current key, so set it null.
        if (qName.equals("key")) {
            currentKey = null;
        }
        if (qName.equals("default") && currentKey != null && currentText != null) {
            // By the end element we have the text if there will be any.
            currentKey.setDefaultValue(currentText.toString());
            currentText = null;
        }
    }

    public void endDocument() {
        System.out.println("End Document.");
        System.out.println(graph);
        for (Key key : keys) {
            System.out.println(key.toString());
        }
    }

}
