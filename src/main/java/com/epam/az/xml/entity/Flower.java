package com.epam.az.xml.entity;

public abstract class Flower extends BaseEntity {
    private String soil;

    public String getSoil() {
        return soil;
    }

    public void setSoil(String soil) {
        this.soil = soil;
    }
}
