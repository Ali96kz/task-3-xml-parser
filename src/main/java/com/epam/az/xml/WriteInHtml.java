package com.epam.az.xml;

import com.epam.az.xml.entity.Flower;
import com.epam.az.xml.entity.GreenHouse;

import java.io.*;

public class WriteInHtml {
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

    public void write(GreenHouse greenHouse) throws IOException {
        File file = new File("./src/main/resources/flower.html");
        OutputStream outputStream = new FileOutputStream(file);

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(htmlStart);

        for (Flower flower : greenHouse.getFlower()) {
            stringBuilder.append(flower+"<br>");
        }
        stringBuilder.append(htmlEnd);

        for (int i = 0; i < stringBuilder.length(); i++) {
             outputStream.write(stringBuilder.charAt(i));
        }
    }
}
