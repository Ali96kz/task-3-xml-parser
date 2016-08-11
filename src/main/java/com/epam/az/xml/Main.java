package com.epam.az.xml;

import com.epam.az.xml.entity.GreenHouse;
import com.epam.az.xml.parser.FlowerStaxParser;
import com.epam.az.xml.parser.FlowersSaxParser;
import com.epam.az.xml.parser.FlowersXmlParser;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        FlowersSaxParser flowerSaxParser = new FlowersSaxParser();
        GreenHouse greenHouse = flowerSaxParser.parseXml("./src/main/resources/greenhouse.xml");
        Class aclass = GreenHouse.class;
        FlowersXmlParser parser = new FlowerStaxParser();
        greenHouse = parser.parseXml("./src/main/resources/greenhouse.xml");
    }
}



