package org.kolokolov.xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class TestSAXHandler extends DefaultHandler {
    
    private boolean bName;
    private boolean bAge;
    private boolean bStreet;
    private boolean bHouse;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        
        switch (qName) {
        case "clients" : 
            System.out.println("*** Clients list ***\n");
            break;
        case "person" : 
            String id = attributes.getValue("id");
            System.out.println("Person, id: " + id);
            break;
        case "address" : 
            System.out.print(" Address: ");
            break;
        case "name" : 
            bName = true;
            break;
        case "age" : 
            bAge = true;
            break;
        case "street" : 
            bStreet = true;
            break;
        case "house" : 
            bHouse = true;
            break;
        default:
            break;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if(bName) {
            System.out.println(" Name: " + new String(ch, start, length));
            bName = false;
        } else if(bAge) {
            System.out.println(" Age: " + new String(ch, start, length));
            bAge = false;
        } else if(bStreet) {
            System.out.print(new String(ch, start, length) + " str., ");
            bStreet = false;
        } else if(bHouse) {
            System.out.println(new String(ch, start, length));
            bHouse = false;
        }
    }
    
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("person")) {
            System.out.println();
        }
    }
}
