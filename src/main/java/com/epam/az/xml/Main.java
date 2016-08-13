package com.epam.az.xml;

import com.epam.az.xml.entity.AliveFlower;
import com.epam.az.xml.entity.GreenHouse;
import com.epam.az.xml.entity.PresentFlower;
import com.epam.az.xml.parser.FlowerDomParser;
import com.epam.az.xml.parser.FlowerStaxParser;
import com.epam.az.xml.parser.FlowersSaxParser;
import com.epam.az.xml.parser.FlowersXmlParser;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
//        FlowersXmlParser flowersXmlParser = new FlowersSaxParser();
//        GreenHouse greenHouse = flowersXmlParser.parseXml("./src/main/resources/greenhouse.xml");
        GreenHouse greenHouse = new GreenHouse();

        Field field = greenHouse.getClass().getDeclaredField("flowers");
        ParameterizedType type = (ParameterizedType) field.getGenericType();
        Type[] typeArguments = type.getActualTypeArguments();
        Class s = (Class) typeArguments[0];
    }
}



