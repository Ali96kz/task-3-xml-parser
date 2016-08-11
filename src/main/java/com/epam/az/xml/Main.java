package com.epam.az.xml;

import com.epam.az.xml.entity.GreenHouse;
import com.epam.az.xml.parser.FlowerSaxParser;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        FlowerSaxParser flowerSaxParser = new FlowerSaxParser();
        GreenHouse greenHouse = flowerSaxParser.parseXml("./src/main/resources/greenhouse.xml");

    }
}



