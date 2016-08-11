package com.epam.az.xml.parser;

import com.epam.az.xml.entity.GreenHouse;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.lang.reflect.Method;


public class FlowerDomParser implements XmlParser {

    @Override
    public GreenHouse parseXml(String path) {
        GreenHouse greenHouse = new GreenHouse();
        try {
            File inputFile = new File(path);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("flowers");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    eElement.getElementsByTagName("").item(0).getTextContent();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return greenHouse;
    }

}
