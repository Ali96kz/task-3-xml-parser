package com.epam.az.xml.entity;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Flower {
    private int id;
    private String name;
    private String soil;
    private VisualParameters visualParameters;
    private String growingTips;
    private Origin origin;

    public Flower() {
    }

    public Flower(int id, String name, String soil, VisualParameters visualParameters, String growingTips, Origin origin) {
        this.id = id;
        this.name = name;
        this.soil = soil;
        this.visualParameters = visualParameters;
        this.growingTips = growingTips;
        this.origin = origin;
    }

    public int getId() {
        return id;
    }
    @XmlAttribute
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    @XmlElement
    public void setName(String name) {
        this.name = name;
    }

    public String getSoil() {
        return soil;
    }
    @XmlElement
    public void setSoil(String soil) {
        this.soil = soil;
    }

    public VisualParameters getVisualParameters() {
        return visualParameters;
    }
    @XmlElement(name = "visual-parametrs")
    public void setVisualParameters(VisualParameters visualParameters) {
        this.visualParameters = visualParameters;
    }

    public String getGrowingTips() {
        return growingTips;
    }
    @XmlElement
    public void setGrowingTips(String growingTips) {
        this.growingTips = growingTips;
    }

    public void setOrigin(Origin origin) {
        this.origin = origin;
    }
    @XmlElement
    public Origin getOrigin() {
        return origin;
    }

    @Override
    public String toString() {
        return id+" "+name+" "+soil+" "+ visualParameters;
    }
}

