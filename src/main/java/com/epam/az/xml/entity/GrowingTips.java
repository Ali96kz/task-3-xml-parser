package com.epam.az.xml.entity;

import javax.xml.bind.annotation.XmlElement;

public class GrowingTips implements DescribeFlower {
    private WaterInWeek waterInWeek;
    private Temperature temperature;
    private boolean lovelight;

    public GrowingTips() {
    }

    public WaterInWeek getWaterInWeek() {
        return waterInWeek;
    }

    @XmlElement(name = "water-in-week")
    public void setWaterInWeek(WaterInWeek waterInWeek) {
        this.waterInWeek = waterInWeek;
    }

    public Temperature getTemperature() {
        return temperature;
    }

    @XmlElement(name = "temperature")
    public void setTemperature(Temperature temperature) {
        this.temperature = temperature;
    }

    public boolean getLovelight() {
        return lovelight;
    }

    @XmlElement
    public void setLovelight(boolean lovelight) {
        this.lovelight = lovelight;
    }

    @Override
    public String toString() {
        return temperature + " " + waterInWeek + " " + lovelight;
    }
}
