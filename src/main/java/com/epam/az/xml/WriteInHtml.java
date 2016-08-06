package com.epam.az.xml;

import com.epam.az.xml.entity.Flower;
import com.epam.az.xml.entity.GreenHouse;

import java.io.*;

public class WriteInHtml {
    public void write(GreenHouse greenHouse) throws IOException {
        File file = new File("./src/main/resources/flower.html");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<!doctype html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Greenhouse flowers</title>\n" +
                "</head>\n" +
                "<body>");

        for (Flower flower : greenHouse.getFlower()) {
            stringBuilder.append(flower+"<br>");
        }

        stringBuilder.append("\n" +
                "</body>\n" +
                "</html>");

        String s = stringBuilder.toString();
        OutputStream outputStream = new FileOutputStream(file);
        for (int i = 0; i < s.length(); i++) {
             outputStream.write(s.charAt(i));
        }
    }
}
