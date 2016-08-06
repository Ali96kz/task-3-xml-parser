package com.epam.az.xml;

import com.epam.az.xml.entity.Flower;
import com.epam.az.xml.entity.GreenHouse;
import com.epam.az.xml.entity.WaterInWeek;
import com.epam.az.xml.parsers.JaxbParser;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        JaxbParser parser = new JaxbParser();
        List<Flower> flowers = parser.parserFlowers("./src/main/resources/greenhouse.xml");
        GreenHouse greenHouse = new GreenHouse();
        WriteInHtml writeInHtml = new WriteInHtml();
        greenHouse.setFlower(flowers);
        for (Flower flower : flowers) {
            System.out.println(flower);
        }
        writeInHtml.write(greenHouse);

    }
}



