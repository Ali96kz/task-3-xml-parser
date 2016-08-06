package com.epam.az.xml.entity;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Flower {
    private int id;
    private String name;
    private String soil;

    private GrowingTips growingTips;
    private Origin origin;
    private VisualParameters visualParameters;

    public Flower() {
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
    public void setGrowingTips(GrowingTips growingTips) {
        this.growingTips = growingTips;
    }

    public GrowingTips getGrowingTips() {
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

