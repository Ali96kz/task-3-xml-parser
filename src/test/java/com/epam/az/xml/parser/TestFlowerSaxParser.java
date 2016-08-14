package com.epam.az.xml.parser;

import com.epam.az.xml.entity.AliveFlower;
import com.epam.az.xml.entity.Flowers;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestFlowerSaxParser {
    FlowersSaxParser flowersSaxParser = new FlowersSaxParser();

    @Test
    public void Size() {
        Flowers flowers = (Flowers) flowersSaxParser.parseXml(Flowers.class, "flowers", "./src/main/resources/greenhouse.xml");
        assertEquals("Flower list contain incorrect number og object", flowers.size(), 2);
    }

    @Test
    public void nestedObjectNotNull() {
        Flowers flowers = (Flowers) flowersSaxParser.parseXml(Flowers.class, "flowers", "./src/main/resources/greenhouse.xml");
        assertNotNull(flowers.get(0).getGrowingTips());
        assertNotNull(flowers.get(0).getGrowingTips().getTemperature());
        assertNotNull(flowers.get(0).getVisualParameters());
    }

    @Test
    public void entity() {
        Flowers flowers = (Flowers) flowersSaxParser.parseXml(Flowers.class, "flowers", "./src/main/resources/greenhouse.xml");
        AliveFlower aliveFlower = flowers.get(0);
        assertTrue("Name = "+aliveFlower.getName(),aliveFlower.getName().equalsIgnoreCase("Rose"));
        assertTrue(aliveFlower.getGrowingTips().getLovelight() == true);
        assertTrue(aliveFlower.getVisualParameters().getColorLeaves().equalsIgnoreCase("green"));

        aliveFlower = flowers.get(1);
        assertTrue(aliveFlower.getName().equalsIgnoreCase("Lavanda"));
        assertTrue(aliveFlower.getGrowingTips().getLovelight() == true);
        assertTrue(aliveFlower.getVisualParameters().getColorLeaves().equalsIgnoreCase("green"));
    }
}

