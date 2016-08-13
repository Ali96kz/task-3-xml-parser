package com.epam.az.xml.parser;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class FlowersSaxParser extends FlowersXmlParser {

    @Override
    public Object parseXml(Class rootClass, String rootlistName, String path) {
        try {
            File inputFile = new File("./src/main/resources/greenhouse.xml");
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            SaxHandler userhandler = new SaxHandler();
            configureParser(rootClass, rootlistName);
            saxParser.parse(inputFile, userhandler);

        } catch (SAXException | IOException | ParserConfigurationException e) {
            e.printStackTrace();
        }
        return getResult();
    }

    class SaxHandler extends DefaultHandler {

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            elementStart( qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            chars(new String(ch, start, length));
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            elementEnd( qName);
        }
    }
}
