package com.epam.az.xml;

import com.epam.az.xml.entity.Flowers;
import com.epam.az.xml.parser.FlowersSaxParser;
import com.epam.az.xml.parser.FlowersXmlParser;


public class Main {
    public static void main(String[] args) {
        FlowersXmlParser flowersXmlParser = new FlowersSaxParser();
        Flowers flowers = (Flowers) flowersXmlParser.parseXml(Flowers.class, "flowers", "/src/main/resources/greenhouse.xml");
        System.out.println(flowers.size() + " " + flowers.get(1));
    }
}



