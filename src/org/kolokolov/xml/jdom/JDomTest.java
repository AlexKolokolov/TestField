package org.kolokolov.xml.jdom;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.Text;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class JDomTest {

    public static void main(String[] args) {
        String[] students = {"Ivan Ivanov", "Petr Petrov", "Fedor Fedorov"};
        
        writeXml(students, "EPA-02", "./out/test.xml");
        readXml("./out/test.xml");
        
    }
    
    public static void writeXml(String[] students, String groupTitle, String fileName) {
        Document doc = new Document();
        Element root = new Element("students");
        doc.addContent(root);
        for (int i = 0; i < students.length; i++) {
            Element student = new Element("student");
            Element name = new Element("name");
            Element group = new Element("group");
            student.setAttribute("id", String.valueOf(i + 1));
            name.addContent(new Text(students[i]));
            group.addContent(new Text(groupTitle));
            student.addContent(name);
            student.addContent(group);
            root.addContent(student);
        }
        
        XMLOutputter outputter = new XMLOutputter(Format.getPrettyFormat());
        try {
            outputter.output(doc, new FileOutputStream(new File(fileName)));
        } catch (IOException e) {
            System.out.println("Exceprion: " + e.getMessage());
        }
    }
    
    public static void readXml(String fileName) {
        SAXBuilder builder = new SAXBuilder();
        
        try {
            Document doc = builder.build(new File(fileName));
            Element root = doc.getRootElement();
            System.out.println(root.getName());
            List<Element> students = root.getChildren();
            students.stream().forEach((s) -> {
                System.out.println(s.getAttributeValue("id") + " " + s.getChildText("name") + " - " + s .getChildText("group"));
            });
            
            
        } catch (JDOMException | IOException e) {
            System.out.println("Exceprion: " + e.getMessage());
        }
        
    }
}
