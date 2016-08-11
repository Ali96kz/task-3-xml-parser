package com.epam.az.xml;

import com.epam.az.xml.entity.AliveFlower;
import com.epam.az.xml.entity.GreenHouse;
import com.epam.az.xml.parser.FlowerSaxParser;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.MalformedParametersException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        FlowerSaxParser flowerSaxParser = new FlowerSaxParser();
        GreenHouse greenHouse =  flowerSaxParser.parseXml("./src/main/resources/greenhouse.xml");
        AliveFlower aliveFlower = greenHouse.getFlower().get(0);
        Method method = AliveFlower.class.getMethod("getName", null);
        method = AliveFlower.class.getMethod("setName", method.getReturnType());
        System.out.println(aliveFlower.getName() +" "+aliveFlower.getOrigin().getCountry());
        System.out.println(aliveFlower.getGrowingTips().getTemperature().getMax());
//         TODO adD VALIDATION
//        TODO DELETE hard RELATIVE FROM PARSER
//        TODO aDD STAX DOMpARSER
    }
}



