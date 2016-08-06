package com.epam.az.xml.parsers;

import com.epam.az.xml.entity.GreenHouse;

import java.io.File;

public interface XmlParser {
    GreenHouse parseXml(String path);
}
