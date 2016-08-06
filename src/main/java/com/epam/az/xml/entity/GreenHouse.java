package com.epam.az.xml.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "greenhouse")
public class GreenHouse {
    private List<Flower> flowers;

    public GreenHouse() {
    }

    public List<Flower> getFlower() {
        return flowers;
    }
    @XmlElement
    public void setFlower(List<Flower> flowers) {
        this.flowers = flowers;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Flower flower : flowers) {
            stringBuilder.append(flower);
        }

        return stringBuilder.toString();
    }
}
