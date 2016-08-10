package com.epam.az.xml;


import com.epam.az.xml.entity.AliveFlower;
import com.epam.az.xml.entity.Flower;
import com.epam.az.xml.entity.FlowerStack;
import com.epam.az.xml.parser.FlowerSaxParser;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        FlowerSaxParser flowerSaxParser = new FlowerSaxParser();
        flowerSaxParser.parseXml("./src/main/resources/greenhouse.xml");
    }
}



