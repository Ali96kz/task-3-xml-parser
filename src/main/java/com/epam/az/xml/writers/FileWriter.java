package com.epam.az.xml.writers;

import java.io.*;

public class FileWriter {
    public void write(File file, StringBuilder stringBuilder){
        OutputStream outputStream ;
        try {
            outputStream = new FileOutputStream(file);
            for (int i = 0; i < stringBuilder.length(); i++) {
                outputStream.write(stringBuilder.charAt(i));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
