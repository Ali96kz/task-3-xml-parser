package com.epam.az.xml;

import com.epam.az.xml.parsers.Parser;

public class Main {
    public static void main(String[] args) {
        Parser parser = new Parser();
        parser.parserFlowers("./src/main/resources/greenhouse.xml");

    }
}



