package com.epam.az.xml.entity;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Flower {
    private int id;
    private String name;
    private String soil;
    private String growingTips;

    private Origin origin;
    private VisualParameters visualParameters;

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

    @XmlAttribute
    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @XmlElement
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @XmlElement
    public void setSoil(String soil) {
        this.soil = soil;
    }

    public String getSoil() {
        return soil;
    }

    @XmlElement(name = "visual-parametrs")
    public void setVisualParameters(VisualParameters visualParameters) {
        this.visualParameters = visualParameters;
    }

    public VisualParameters getVisualParameters() {
        return visualParameters;
    }

    @XmlElement(name = "growing-tips")
    public void setGrowingTips(String growingTips) {
        this.growingTips = growingTips;
    }

    public String getGrowingTips() {
        return growingTips;
    }

    @XmlElement
    public Origin getOrigin() {
        return origin;
    }

    public void setOrigin(Origin origin) {
        this.origin = origin;
    }


    @Override
    public String toString() {
        return id+" "+name+" "+soil+" "+visualParameters
                +" "+origin+" "+growingTips;
    }
}

