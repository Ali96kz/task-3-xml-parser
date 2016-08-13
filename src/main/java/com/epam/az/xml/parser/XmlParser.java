package com.epam.az.xml.parser;

public interface XmlParser {
    Object parseXml(Class rootClass, String rootList, String path);

}
