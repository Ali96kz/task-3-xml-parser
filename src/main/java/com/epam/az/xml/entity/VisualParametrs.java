package com.epam.az.xml.entity;

import javax.xml.bind.annotation.XmlElement;

public class VisualParametrs {
    private String colorSteam;
    private String colorLeaves;
    private int averageHeight;

    public VisualParametrs(){
    }

    public String getColorSteam() {
        return colorSteam;
    }
    @XmlElement(name = "color-steam")
    public void setColorSteam(String colorSteam) {
        this.colorSteam = colorSteam;
    }

    public String getColorLeaves() {
        return colorLeaves;
    }
    @XmlElement(name = "color-leaves")
    public void setColorLeaves(String colorLeaves) {
        this.colorLeaves = colorLeaves;
    }

    public int getAverageHeight() {
        return averageHeight;
    }
    @XmlElement(name = "average-height")
    public void setAverageHeight(int averageHeight) {
        this.averageHeight = averageHeight;
    }

    @Override
    public String toString() {
        return colorLeaves+" "+colorSteam+" "+averageHeight;
    }
}
