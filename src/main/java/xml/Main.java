package xml;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.io.InputStream;

public class Main {
    public static void main(String[] args) {
        SAXParserFactory spf = SAXParserFactory.newInstance();

        try (InputStream input = Main.class.getClassLoader().getResourceAsStream("graphml1.xml")) {
            SAXParser parser = spf.newSAXParser();
            SimpleXMLHandler handler = new SimpleXMLHandler();
            parser.parse(input, handler);
        }
        catch (IOException e) {
            System.out.println("Unable to open file.");
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }
    }
}
