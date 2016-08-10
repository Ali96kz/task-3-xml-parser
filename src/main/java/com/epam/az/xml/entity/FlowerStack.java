package com.epam.az.xml.entity;

import java.util.ArrayList;
import java.util.List;

public class FlowerStack<E> {
    private List<E> values = new ArrayList<>();
    private List<Integer> counts = new ArrayList<>();

    public void pop() {
        if (values.size() > 1) {
            if (counts.get(counts.size() - 1) > 0) {
                counts.set(counts.size()-1, counts.get(counts.size()-1) - 1);
            } else
                values.remove(values.size() - 1);
        }
    }

    public E getLast() {
        return values.get(values.size()-1);
    }
    public int getLastIndex(){
        return values.size();
    }
    public void push(E item) {
        values.add(item);
    }

    public void setCount(int n) {
        counts.add(n);
    }
    public int getLastQuantity(){
        if(values.get(values.size()-1) instanceof AliveFlower){
            return 3;
        }
        System.out.println(values.size()+" " + counts.size());
        return counts.get(values.size()-1);
    }
}
