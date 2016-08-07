package com.epam.az.xml.writers;

import com.epam.az.xml.entity.Flower;
import com.epam.az.xml.entity.GreenHouse;

import java.io.*;

public class WriterInHtml {
    private String htmlStart = "<!doctype html>\n" +
            "<html lang=\"en\">\n" +
            "<head>\n" +
            "    <meta charset=\"UTF-8\">\n" +
            "    <title>Greenhouse flowers</title>\n" +
            "</head>\n" +
            "<body>";
    private String htmlEnd = "\n" +
            "</body>\n" +
            "</html>";

    public void write(GreenHouse greenHouse) {
        File file = new File("./src/main/resources/flower.html");
        com.epam.az.xml.writers.FileWriter fileWriter = new com.epam.az.xml.writers.FileWriter();
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(htmlStart);
        for (Flower flower : greenHouse.getFlower()) {
            stringBuilder.append(flower+"<br>");
        }
        stringBuilder.append(htmlEnd);
        fileWriter.write(file, stringBuilder);
    }
}
