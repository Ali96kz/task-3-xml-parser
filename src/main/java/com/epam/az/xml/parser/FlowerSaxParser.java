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
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class FlowerSaxParser implements XmlParser {
    FlowerStack<Object> flowerStack = new FlowerStack();

    @Override
    public GreenHouse parseXml(String path) {
        try {
            flowerStack.push(new AliveFlower());
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


    class SaxHandler extends DefaultHandler {
        private StringBuilder stringBuilder = new StringBuilder();
        private Class clazz;
        private Method method;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            try {
                System.out.println(upFirstChar(qName)+" <----");
                Method getMethod = flowerStack.getLast().getClass().getMethod("get" + upFirstChar(qName), null);
                System.out.println(upFirstChar(qName));
                method = flowerStack.getLast().getClass().getMethod("set" + upFirstChar(qName), getMethod.getReturnType());
                clazz = method.getParameterTypes()[0];
                if (!clazz.isPrimitive() && clazz != Object.class && clazz != String.class) {
                    Object b = clazz.newInstance();
                    flowerStack.push(b);
                    pushObjectInStack(clazz.getDeclaredMethods(), b);
                }

            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            stringBuilder.append(ch, start, length);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            Object value = stringBuilderToObjectType(stringBuilder, clazz);
            invokeMethodByName(flowerStack.pop(), value);
            stringBuilder = new StringBuilder();
        }

        public Object stringBuilderToObjectType(StringBuilder stringBuilder, Class aclass) {
            if (aclass.getName() == "int") {
                String s = stringBuilder.toString().trim();
                int result = Integer.parseInt(s);
                return result;
            }
            return stringBuilder.toString();
        }

        public void pushObjectInStack(Method[] methods, Object object) {
            for (Method method1 : methods) {
                if (method1.getName().startsWith("get")) {
                    flowerStack.push(object);
                }
            }
        }

        private void invokeMethodByName(Object inputClass, Object value) {
            try {
                method.invoke(inputClass, value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        public String upFirstChar(String str){
            String result = new String(String.valueOf(str.charAt(0)));
            result = result.toUpperCase();

            char [] sd = str.toCharArray();
            sd[0] = result.charAt(0);

            str = new String(sd);
            return str;
        }
    }
}
