package com.epam.az.xml.entity;

public class AliveFlower extends PresentFlower {
    private int aliveDay;
    private GrowingTips growingTips;
    String str;
    public AliveFlower() {

    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public int getAliveDay() {
        return aliveDay;
    }

    public void setAliveDay(int aliveDay) {
        this.aliveDay = aliveDay;
    }
}
