package com.epam.az.xml;

import com.epam.az.xml.entity.AliveFlower;
import com.epam.az.xml.entity.GreenHouse;
import com.epam.az.xml.parser.FlowerStaxParser;
import com.epam.az.xml.parser.FlowersSaxParser;
import com.epam.az.xml.parser.FlowersXmlParser;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        FlowersXmlParser flowerStaxparser = new FlowerStaxParser();
        FlowersXmlParser parsers = new FlowersSaxParser();
        GreenHouse staxGreenHouse = flowerStaxparser.parseXml("./src/main/resources/greenhouse.xml");
        GreenHouse saxGreenHouse = parsers.parseXml("./src/main/resources/greenhouse.xml");

    }
}



