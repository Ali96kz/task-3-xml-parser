package com.epam.az.xml;

import com.epam.az.xml.entity.AliveFlower;
import com.epam.az.xml.entity.GreenHouse;
import com.epam.az.xml.parser.FlowersSaxParser;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        FlowersSaxParser flowerSaxParser = new FlowersSaxParser();
        GreenHouse greenHouse = flowerSaxParser.parseXml("./src/main/resources/greenhouse.xml");
        AliveFlower aliveFlower = (AliveFlower) greenHouse.get(0);
    }
}



