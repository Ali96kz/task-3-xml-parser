package com.epam.az.xml.parser;

import com.epam.az.xml.entity.GreenHouse;


public interface XmlParser {
    GreenHouse parseXml(String path);
//    GreenHouse parserXml(InputStream inputStream);

}
