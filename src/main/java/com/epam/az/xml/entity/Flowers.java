package com.epam.az.xml.entity;

import java.util.ArrayList;
import java.util.List;

public class Flowers {
    private List<AliveFlower> flowers = new ArrayList<>();

    public Flowers() {
    }

    public List<AliveFlower> getFlower() {
        return flowers;
    }

    public void setFlower(AliveFlower flower) {
        flowers.add(flower);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Flower flower : flowers) {
            stringBuilder.append(flower + "\n");
        }

        return stringBuilder.toString();
    }

    public AliveFlower get(int index) {
        return flowers.get(index);
    }

    public void add(AliveFlower flower) {
        flowers.add(flower);
    }

    public void remove(int index) {
        flowers.remove(index);
    }

    public List<AliveFlower> getFlowers() {
        List<AliveFlower> result = new ArrayList<>(flowers.size());
        for (AliveFlower flower : flowers) {
            result.add(flower);
        }
        return result;
    }

    public int size() {
        return flowers.size();
    }
}
