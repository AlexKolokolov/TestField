package org.kolokolov.xml;

import java.util.ArrayList;
import java.util.List;

import org.kolokolov.xml.model.Address;
import org.kolokolov.xml.model.Person;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class TestModelSAXHandler extends DefaultHandler{
    private boolean bName;
    private boolean bAge;
    private boolean bStreet;
    private boolean bHouse;
    
    private List<Person> clientList = new ArrayList<>();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        
        switch (qName) {
        case "clients" : 
            System.out.println("*** Clients list ***\n");
            break;
        case "person" : 
            String id = attributes.getValue("id");
            Person person = new Person();
            person.setId(Integer.parseInt(id));
            clientList.add(person);
            break;
        case "address" :
            Address address = new Address();
            Person currentPerson = clientList.get(clientList.size() - 1);
            currentPerson.setAddress(address);
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
        Person currentPerson = null;
        Address currentPersonAddress = null;

        if (!clientList.isEmpty()) {
            currentPerson = clientList.get(clientList.size() - 1);
            currentPersonAddress = currentPerson.getAddress();
        }
 
        if(bName) {
            String name = new String(ch, start, length);
            currentPerson.setName(name);
            bName = false;
        } else if(bAge) {
            int age = Integer.parseInt(new String(ch, start, length));
            currentPerson.setAge(age);
            bAge = false;
        } else if(bStreet) {
            String street = new String(ch, start, length);
            currentPersonAddress.setStreet(street);
            bStreet = false;
        } else if(bHouse) {
            int house = Integer.parseInt(new String(ch, start, length));
            currentPersonAddress.setHouse(house);
            bHouse = false;
        }
    }

    public List<Person> getClientList() {
        return clientList;
    }
}
