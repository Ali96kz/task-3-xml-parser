package com.epam.az.xml;

import com.epam.az.xml.entity.GreenHouse;
import com.epam.az.xml.parsers.JaxbParser;
import com.epam.az.xml.parsers.XmlParser;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        XmlParser parser = new JaxbParser();
        WriterInHtml writerInHtml = new WriterInHtml();
        GreenHouse greenHouse = parser.parseXml("./src/main/resources/greenhouse.xml");

        System.out.println(greenHouse);
        writerInHtml.write(greenHouse);
    }
}



