package com.epam.az.xml.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "greenhouse")
public class GreenHouse {
    private List<AliveFlower> flowers;

    public GreenHouse() {
    }

    public List<AliveFlower> getFlower() {
        return flowers;
    }
    @XmlElement
    public void setFlower(List<AliveFlower> flowers) {
        this.flowers = flowers;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Flower flower : flowers) {
            stringBuilder.append(flower+"\n");
        }

        return stringBuilder.toString();
    }
    public Flower get(int index){
        return flowers.get(index);
    }
    public void add(AliveFlower flower){
        flowers.add(flower);
    }
    public void remove(int index){
        flowers.remove(index);
    }
    public List<AliveFlower> getFlowers(){
        List<AliveFlower> result = new ArrayList<>(flowers.size());
        for (AliveFlower flower : flowers) {
            result.add(flower);
        }
        return result;
    }
}
