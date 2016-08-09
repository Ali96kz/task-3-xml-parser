package com.epam.az.xml.entity;

public class AliveFlower extends PresentFlower {
    private int aliveDay;
    private GrowingTips growingTips;
    public AliveFlower() {

    }

    public int getAliveDay() {
        return aliveDay;
    }

    public void setAliveDay(int aliveDay) {
        this.aliveDay = aliveDay;
    }
}
