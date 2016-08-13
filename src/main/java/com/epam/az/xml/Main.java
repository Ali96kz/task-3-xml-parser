package com.epam.az.xml;

import com.epam.az.xml.entity.Flower;
import com.epam.az.xml.entity.Flowers;
import com.epam.az.xml.parser.FlowersSaxParser;
import com.epam.az.xml.parser.FlowersXmlParser;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class Main {
    public static void main(String[] args){
        FlowersXmlParser flowersXmlParser = new FlowersSaxParser();
        Flowers flowers = (Flowers) flowersXmlParser.parseXml(Flowers.class, "flowers", "/src/main/resources/greenhouse.xml");
    }
}



