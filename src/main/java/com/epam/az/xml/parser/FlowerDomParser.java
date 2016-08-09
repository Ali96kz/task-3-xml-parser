package com.epam.az.xml.parser;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import com.epam.az.xml.entity.Flower;
import com.epam.az.xml.entity.GreenHouse;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class FlowerDomParser implements XmlParser{

    @Override
    public GreenHouse parseXml(String path) {
        GreenHouse greenHouse = new GreenHouse();
        try {
            File inputFile = new File(path);
            DocumentBuilderFactory dbFactory
                    = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("flower");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return greenHouse;
    }
}
