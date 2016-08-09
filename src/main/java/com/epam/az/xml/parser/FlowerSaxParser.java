package com.epam.az.xml.parser;

import com.epam.az.xml.entity.*;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
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

        StringBuilder stringBuilder  = new StringBuilder();
        Class clazz;
        Method method;
        AliveFlower aliveFlower = new AliveFlower();
        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            try {
                method = AliveFlower.class.getMethod("set"+qName);
                clazz = method.getReturnType();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            stringBuilder.append(ch, start, length);

        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            Object obj = stringBuilderToObjectType(stringBuilder ,clazz);
            invokeMethodByName(obj);
            stringBuilder = new StringBuilder();
        }

        public Object stringBuilderToObjectType(StringBuilder stringBuilder, Class aclass){
            if(aclass.getTypeName() == "int"){
                int result = Integer.parseInt(stringBuilder.toString());
                return result;
            }else if(aclass.getTypeName() == "string"){
            }
            return "sd";
        }

        private  void invokeMethodByName(Object value) {
            try {
                method.invoke(aliveFlower, value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }

        }

        private   boolean isSetter(Method method){
            if(method.getName().startsWith("set")) return true;
            return false;
        }
    }
}
