package org.kolokolov.xml;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.XMLReader;

public class TestSAXXmlReader {
    public static void main(String[] args) {
        String fileName = "/home/kolokolov/java/EclipseProjects/TestField/test/Test.xml";
        SAXParserFactory parserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = parserFactory.newSAXParser();
            XMLReader reader = parser.getXMLReader();
            reader.setContentHandler(new TestSAXHandler());
            reader.parse(fileName);
            TestModelSAXHandler myHandler = new TestModelSAXHandler();
            reader.setContentHandler(myHandler);
            reader.parse(fileName);
            myHandler.getClientList().stream().forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
