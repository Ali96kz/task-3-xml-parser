package com.epam.az.xml.parser;

import com.epam.az.xml.entity.AliveFlower;
import com.epam.az.xml.entity.FlowerStack;
import com.epam.az.xml.entity.GreenHouse;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public abstract class FlowersXmlParser implements XmlParser{
    protected StringBuilder stringBuilder = new StringBuilder();
    protected Class clazz;
    protected Method method;
    FlowerStack flowerStack = new FlowerStack();
    String rootName = "flower", listName = "flowers";
    protected void elementStart(String qName){
        try {
            if (qName.equalsIgnoreCase(rootName)) {
                flowerStack = new FlowerStack();
                AliveFlower aliveFlower = new AliveFlower();
                flowerStack.push(aliveFlower);
            } else if (qName.equalsIgnoreCase(listName)) {

            } else {

                Method getMethod = flowerStack.getLast().getClass().getMethod("get" + upFirstChar(qName), null);
                method = flowerStack.getLast().getClass().getMethod("set" + upFirstChar(qName), getMethod.getReturnType());
                clazz = getMethod.getReturnType();
                if (!clazz.isPrimitive() && clazz != Object.class && clazz != String.class) {
                    pushObjectInStack(clazz.getDeclaredMethods(), clazz.newInstance(), flowerStack);
                }
            }

        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

    }
    protected void chars(String string){
        stringBuilder.append(string);
    }
    protected void elementEnd(String qName, GreenHouse greenHouse){
        if (qName.equalsIgnoreCase("flower")) {
            greenHouse.add((AliveFlower) flowerStack.pop());
        } else if (qName.equalsIgnoreCase("flowers")) {

        } else if (qName.equalsIgnoreCase(flowerStack.getLast().getClass().getSimpleName())) {
            Object value = flowerStack.pop();
            invokeSetterForObject(flowerStack.pop(), value);
        } else {
            String characterValue = stringBuilder.toString().replaceAll("\\s","");
            Object value = stringToObjectType(characterValue, clazz);
            invokeSetterForPrimitive(flowerStack.pop(), value);
        }
        stringBuilder = new StringBuilder();
    }

    public Object stringToObjectType(String str, Class aclass) {
        if (aclass.getSimpleName() == "int") {
            try {
                int result = Integer.parseInt(str);
                return result;
            } catch (NumberFormatException e) {
            }
        }
        if(aclass.getSimpleName() == "boolean"){
            if(str.charAt(0) == 't'){
                return true;
            }else {
                return false;
            }
        }
        return stringBuilder.toString();
    }

    protected void pushObjectInStack(Method[] methods, Object object, FlowerStack flowerStack) {
        for (Method method1 : methods) {
            if (method1.getName().startsWith("get")) {
                flowerStack.push(object);
            }
        }
        flowerStack.push(object);
    }

    protected void invokeSetterForPrimitive(Object inputClass, Object value) {
        try {
            method.invoke(inputClass, value);
        } catch (IllegalAccessException | InvocationTargetException | IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
    protected void invokeSetterForObject(Object inputClass, Object value){
        try {
            Method getMethod = inputClass.getClass().getMethod("get" + value.getClass().getSimpleName(), null);
            Method setMethod = inputClass.getClass().getMethod("set" + value.getClass().getSimpleName(), getMethod.getReturnType());
            setMethod.invoke(inputClass, value);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    protected String upFirstChar(String str) {
        String result = new String(String.valueOf(str.charAt(0)));
        result = result.toUpperCase();
        char[] sd = str.toCharArray();
        sd[0] = result.charAt(0);
        str = new String(sd);
        return str;
    }
}

