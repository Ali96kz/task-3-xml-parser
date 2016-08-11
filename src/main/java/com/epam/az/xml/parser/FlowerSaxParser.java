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
        AliveFlower aliveFlower = new AliveFlower();
        try {
            flowerStack.push(aliveFlower);
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
        GreenHouse greenHouse = new GreenHouse();
        greenHouse.add(aliveFlower);
        return greenHouse;

    }


    class SaxHandler extends DefaultHandler {
        private StringBuilder stringBuilder = new StringBuilder();
        private Class clazz;
        private Method method;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            try {
                Method getMethod = flowerStack.getLast().getClass().getMethod("get" + upFirstChar(qName), null);
                method = flowerStack.getLast().getClass().getMethod("set" + upFirstChar(qName), getMethod.getReturnType());
                clazz = getMethod.getReturnType();
                if (!clazz.isPrimitive() && clazz != Object.class && clazz != String.class) {

                    Object b = clazz.newInstance();
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
            if (qName.equalsIgnoreCase(flowerStack.getLast().getClass().getSimpleName()) && !qName.equalsIgnoreCase("flower")) {
                Object value = flowerStack.pop();
                System.out.println(value.getClass().getSimpleName());
                invokeMethodByName(flowerStack.pop(), value);
            } else {
                Object value = stringBuilderToObjectType(stringBuilder, clazz);
                invokeMethodByName(flowerStack.pop(), value);
            }
            stringBuilder = new StringBuilder();
        }

        public Object stringBuilderToObjectType(StringBuilder stringBuilder, Class aclass) {

            if (aclass.getName() == "int") {
                String s = stringBuilder.toString().trim();
                try {
                    int result = Integer.parseInt(s);
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

        private void invokeMethodByName(Object inputClass, Object value) {
          /*  System.out.println("---------------------------\n"+
                    "method  = " + method.getName() + " inputClass = " + inputClass.getClass()
                    + " value = " + value + " value is primitive" + value.getClass()
            +"-------------------------------\n");*/
            Class aClass = value.getClass();
            try {
                if (!aClass.isPrimitive() && aClass != String.class && aClass != Integer.class) {
                    System.out.println("was");
                    Method getMethod = flowerStack.getLast().getClass().getMethod("get" + value.getClass().getSimpleName(), null);
                    method = flowerStack.getLast().getClass().getMethod("set" + value.getClass().getSimpleName(), getMethod.getReturnType());
                    method.invoke(inputClass, value);

                } else if (value.getClass().isPrimitive() || value.getClass() == String.class || value.getClass() == Integer.class) {
                    method.invoke(inputClass, value);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (IllegalArgumentException e) {
                System.out.println();
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
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
