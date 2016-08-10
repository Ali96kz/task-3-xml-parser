package com.epam.az.xml.entity;
public abstract class PresentFlower extends Flower {
    private int height;
    private FlowerVisualParameters visualParameters;
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public FlowerVisualParameters getVisualParameters() {
        return visualParameters;
    }

    public void setVisualParameters(FlowerVisualParameters visualParameters) {
        this.visualParameters = visualParameters;
    }
}
