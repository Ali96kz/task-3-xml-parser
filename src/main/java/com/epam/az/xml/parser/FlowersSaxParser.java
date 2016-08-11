package com.epam.az.xml.parser;

import com.epam.az.xml.entity.AliveFlower;
import com.epam.az.xml.entity.FlowerStack;
import com.epam.az.xml.entity.GreenHouse;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

public class FlowersSaxParser extends FlowersXmlParser {
    FlowerStack<Object> flowerStack = new FlowerStack();
    GreenHouse greenHouse = new GreenHouse();

    @Override
    public GreenHouse parseXml(String path) {
        try {
            flowerStack.push(new AliveFlower());
            File inputFile = new File("./src/main/resources/greenhouse.xml");
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            SaxHandler userhandler = new SaxHandler();
            saxParser.parse(inputFile, userhandler);


        } catch (SAXException | IOException | ParserConfigurationException e) {
            e.printStackTrace();
        }

        return greenHouse;

    }


    class SaxHandler extends DefaultHandler {

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            elementStart(flowerStack, qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            chars(new String(ch, start, length));
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            elementEnd(flowerStack, qName, greenHouse);
        }
    }
}
