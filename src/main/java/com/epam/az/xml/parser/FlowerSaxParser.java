package com.epam.az.xml.parser;

import com.epam.az.xml.entity.AliveFlower;
import com.epam.az.xml.entity.BaseEntity;
import com.epam.az.xml.entity.Flower;
import com.epam.az.xml.entity.GreenHouse;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class FlowerSaxParser implements XmlParser{
    GreenHouse greenHouse = new GreenHouse();
    BaseEntity baseEntity = new AliveFlower();

    @Override
    public GreenHouse parseXml(String path) {
        try{
            File inputFile = new File("./src/main/resources/greenhouse.xml");
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            SaxHandler userhandler = new SaxHandler();
            saxParser.parse(inputFile, userhandler);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        return null;
    }
    public void invokeMethodByName(String name){

    }


    class SaxHandler extends DefaultHandler{
        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

            Method methods[] = AliveFlower.class.getDeclaredMethods();
            try {
                AliveFlower aliveFlower = AliveFlower.class.newInstance();
                for (Method method : methods) {
                    if(isSetter(method)){
                        invokeMethodByName("set"+"qName");

                    }
                }
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        public  boolean isSetter(Method method){
            if(method.getName().startsWith("set")) return true;
            return false;
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            Flower flower = new AliveFlower();
            flower.setId(1);
            Field field[]  = GreenHouse.class.getDeclaredFields();

        }

    }
}
