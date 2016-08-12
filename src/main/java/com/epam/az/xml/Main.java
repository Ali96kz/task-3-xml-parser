package com.epam.az.xml;

import com.epam.az.xml.entity.GreenHouse;
import com.epam.az.xml.parser.FlowerDomParser;
import com.epam.az.xml.parser.FlowerStaxParser;
import com.epam.az.xml.parser.FlowersSaxParser;
import com.epam.az.xml.parser.FlowersXmlParser;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        FlowersXmlParser flowersXmlParser = new FlowersSaxParser();
        GreenHouse greenHouse = flowersXmlParser.parseXml("./src/main/resources/greenhouse.xml");
    }
}



