package com.epam.az.xml;


import com.epam.az.xml.entity.AliveFlower;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        List<String> values = new ArrayList<>();
        values.add("asd");
        System.out.println(values.size());
    }
    //TODO WorkWithComplexType

}



