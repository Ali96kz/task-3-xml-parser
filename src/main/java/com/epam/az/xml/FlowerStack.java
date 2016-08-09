package com.epam.az.xml;

import java.util.ArrayList;
import java.util.List;

public class FlowerStack<E> {
    private List<E> values = new ArrayList<>();

    public void pop() {
        if (values.size() > 1)
            values.remove(values.size() - 1);
    }

    public E getLast() {
        return values.get(values.size());
    }

    public void push(E item) {
        values.add(item);
    }
}
