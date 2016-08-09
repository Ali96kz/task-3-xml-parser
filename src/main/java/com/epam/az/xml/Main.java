package com.epam.az.xml;

import com.epam.az.xml.entity.AliveFlower;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args)  {
        Method methods[] = AliveFlower.class.getDeclaredMethods();
        try {
            AliveFlower aliveFlower = AliveFlower.class.newInstance();
            for (Method method : methods) {

            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
    public static boolean isSetter(Method method){
        if(method.getName().startsWith("set")) return true;
        return false;
    }
}



