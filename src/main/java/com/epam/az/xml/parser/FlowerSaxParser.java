package com.epam.az.xml.parser;

import com.epam.az.xml.entity.AliveFlower;
import com.epam.az.xml.entity.FlowerStack;
import com.epam.az.xml.entity.GreenHouse;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.swing.text.html.parser.Parser;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class FlowerSaxParser implements XmlParser {
    FlowerStack<Object> flowerStack = new FlowerStack();
    GreenHouse greenHouse = new GreenHouse();

    @Override
    public GreenHouse parseXml(String path) {
        try {
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
        private StringBuilder stringBuilder = new StringBuilder();

        private Class clazz;
        private Method method;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            try {
                if (qName.equalsIgnoreCase("flower")) {
                    flowerStack = new FlowerStack();
                    AliveFlower aliveFlower = new AliveFlower();
                    flowerStack.push(aliveFlower);
                } else if (qName.equalsIgnoreCase("flowers")) {

                } else {
                    Method getMethod = flowerStack.getLast().getClass().getMethod("get" + upFirstChar(qName), null);
                    method = flowerStack.getLast().getClass().getMethod("set" + upFirstChar(qName), getMethod.getReturnType());
                    clazz = getMethod.getReturnType();
                    if (!clazz.isPrimitive() && clazz != Object.class && clazz != String.class) {
                        Object b = clazz.newInstance();
                        pushObjectInStack(clazz.getDeclaredMethods(), b);
                    }
                }

            } catch (NoSuchMethodException | InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }

        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            stringBuilder.append(ch, start, length);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("flower")) {
                greenHouse.add((AliveFlower) flowerStack.pop());
            } else if (qName.equalsIgnoreCase("flowers")) {

            } else if (qName.equalsIgnoreCase(flowerStack.getLast().getClass().getSimpleName())) {
                Object value = flowerStack.pop();
                invokeSetterForObject(flowerStack.pop(), value);
            } else {
                Object value = stringToObjectType(stringBuilder.toString().trim(), clazz);
                invokeSetterForPrimitive(flowerStack.pop(), value);
            }
            stringBuilder = new StringBuilder();
        }

        public Object stringToObjectType(String str, Class aclass) {
            if (aclass.getName() == "int") {
                try {
                    int result = Integer.parseInt(str);
                    return result;
                } catch (NumberFormatException e) {
                }
            }
            return stringBuilder.toString();
        }

        public void pushObjectInStack(Method[] methods, Object object) {
            for (Method method1 : methods) {
                if (method1.getName().startsWith("get")) {
                    flowerStack.push(object);
                }
            }
            flowerStack.push(object);
        }

        private void invokeSetterForPrimitive(Object inputClass, Object value) {
            Class aClass = value.getClass();
            try {
                if (!aClass.isPrimitive() && aClass != String.class && aClass != Integer.class) {

                } else  {
                    method.invoke(inputClass, value);
                }
            } catch (IllegalAccessException | InvocationTargetException | IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
        public void invokeSetterForObject(Object inputClass, Object value){
            try {
                Method getMethod = inputClass.getClass().getMethod("get" + value.getClass().getSimpleName(), null);
                method = inputClass.getClass().getMethod("set" + value.getClass().getSimpleName(), getMethod.getReturnType());
                method.invoke(inputClass, value);
            } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        public String upFirstChar(String str) {
            String result = new String(String.valueOf(str.charAt(0)));
            result = result.toUpperCase();
            char[] sd = str.toCharArray();
            sd[0] = result.charAt(0);
            str = new String(sd);
            return str;
        }
    }
}
