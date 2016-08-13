package com.epam.az.xml.parser;

import com.epam.az.xml.entity.AliveFlower;
import com.epam.az.xml.entity.FlowerStack;
import com.epam.az.xml.entity.GreenHouse;

import java.lang.reflect.*;


public abstract class FlowersXmlParser implements XmlParser {
    protected StringBuilder stringBuilder = new StringBuilder();
    protected Class clazz;
    protected Method method;
    //TODO get this parameters from root class

    String rootItem = "flower", root = "flowers";
    FlowerStack flowerStack ;
    Class rootItemClass;
    Object rootInstance ;
    Method addObjectInList;

    public void configureParser(Class rootClass, String rootItem) {
        try {
            Field field = rootClass.getField(rootItem);
            ParameterizedType type = (ParameterizedType) field.getGenericType();
            Type[] typeArguments = type.getActualTypeArguments();;
            rootItemClass = (Class) typeArguments[0];
            Class returnType= rootClass.getMethod("get"+rootItem, null).getReturnType();
            addObjectInList = rootClass.getDeclaredMethod("add" + rootItem, returnType);
            rootInstance = rootClass.newInstance();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }


    protected void elementStart(String qName) {
        try {
            if (qName.equalsIgnoreCase(rootItem)) {
                flowerStack = new FlowerStack();
                Object item = rootItemClass.newInstance();
                flowerStack.push(item);
            } else if (qName.equalsIgnoreCase(root)) {

            } else {
                Method getMethod = flowerStack.getLast().getClass().getMethod("get" + upFirstChar(qName), null);
                method = flowerStack.getLast().getClass().getMethod("set" + upFirstChar(qName), getMethod.getReturnType());
                clazz = getMethod.getReturnType();
                if (!clazz.isPrimitive() && clazz != String.class) {
                    pushObjectInStack(clazz.getDeclaredMethods(), clazz.newInstance(), flowerStack);
                }
            }

        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

    }

    protected void chars(String string) {
        stringBuilder.append(string);
    }

    protected void elementEnd(String qName, GreenHouse greenHouse) {
        if (qName.equalsIgnoreCase(rootItem)) {
            addInRootList(flowerStack.pop());
        } else if (qName.equalsIgnoreCase(root)) {

        } else if (qName.equalsIgnoreCase(flowerStack.getLast().getClass().getSimpleName())) {
            Object value = flowerStack.pop();
            invokeSetterForObject(flowerStack.pop(), value);
        } else {
            String characterValue = stringBuilder.toString().replaceAll("\\s", "");
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
        if (aclass.getSimpleName().equalsIgnoreCase("boolean")) {
            if (str.equalsIgnoreCase("true")) {
                return true;
            } else {
                return false;
            }
        }
        return stringBuilder.toString();
    }
    private void addInRootList(Object value){
        try {
            addObjectInList.invoke(rootInstance, value);
        } catch (IllegalAccessException | InvocationTargetException  e) {
            e.printStackTrace();
        }
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

    protected void invokeSetterForObject(Object inputClass, Object value) {
        try {
            Method getMethod = inputClass.getClass().getMethod("get" + value.getClass().getSimpleName(), null);
            Method setMethod = inputClass.getClass().getMethod("set" + value.getClass().getSimpleName(), getMethod.getReturnType());
            setMethod.invoke(inputClass, value);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    protected String upFirstChar(String str) {
        char[] charArray = str.toCharArray();
        charArray[0] = Character.toUpperCase(charArray[0]);
        String result = new String(charArray);
        return result;
    }
}

