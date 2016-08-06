package com.epam.az.xml.parsers;

import com.epam.az.xml.entity.GreenHouse;


public interface XmlParser {
    GreenHouse parseXml(String path);
}
