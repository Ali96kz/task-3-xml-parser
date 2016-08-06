package com.epam.az.xml;

import com.epam.az.xml.entity.Flower;
import com.epam.az.xml.entity.GreenHouse;
import com.epam.az.xml.parsers.JaxbParser;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        JaxbParser parser = new JaxbParser();
        GreenHouse greenHouse = new GreenHouse();
        greenHouse.setFlower(parser.parserFlowers("./src/main/resources/greenhouse.xml"));

        WriteInHtml writeInHtml = new WriteInHtml();
        for (Flower flower : greenHouse.getFlower()) {
            System.out.println(flower);
        }

        writeInHtml.write(greenHouse);
    }
}



