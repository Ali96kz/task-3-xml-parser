package com.epam.az.xml;

import com.epam.az.xml.entity.Flower;
import com.epam.az.xml.parsers.JaxbParser;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        JaxbParser parser = new JaxbParser();
        List<Flower> flowers = parser.parserFlowers("./src/main/resources/greenhouse.xml");
        for (Flower flower : flowers) {
            System.out.println(flower);
        }
    }
}



