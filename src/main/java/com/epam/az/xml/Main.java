package com.epam.az.xml;

import com.epam.az.xml.parsers.SaxHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;


public class Main {

    public static void main(String[] args)  {
        try {
            File inputFile = new File("./src/main/resources/greenhouse.xml");
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            SaxHandler userhandler = new SaxHandler();
            saxParser.parse(inputFile, userhandler);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}



