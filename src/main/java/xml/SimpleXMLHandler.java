package xml;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class SimpleXMLHandler extends DefaultHandler {
    @Override
    public void startDocument() {
        System.out.println("Start Document.");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        System.out.println("Start Element : " + qName);
        System.out.println("Attributes: ");
        for (int i = 0; i < attributes.getLength(); i++) {
            System.out.println("- QName: " + attributes.getQName(i));
            System.out.println("- Value: " + attributes.getValue(i));
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        System.out.println("End Element: " + qName);
    }

    public void endDocument() {
        System.out.println("End Document.");
    }

}
