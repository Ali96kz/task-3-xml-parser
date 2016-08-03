package com.epam.az.xml.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "greenhouse")
public class GreenHouse {
    private List<Flower> flower ;

    public GreenHouse() {
    }

    public List<Flower> getFlower() {
        return flower;
    }
    @XmlElement
    public void setFlower(List<Flower> flower) {
        this.flower = flower;
    }
}
