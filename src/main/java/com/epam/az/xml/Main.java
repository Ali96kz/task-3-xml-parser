package com.epam.az.xml;

import com.epam.az.xml.parser.FlowerSaxParser;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        FlowerSaxParser flowerSaxParser = new FlowerSaxParser();
        flowerSaxParser.parseXml("./src/main/resources/greenhouse.xml");
//       TODO adD VALIDATION
//        TODO DELETE hard RELATIVE FROM PARSER
//        TODO aDD STAX DOMpARSER
    }
}



