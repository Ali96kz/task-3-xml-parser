package com.epam.az.xml.parser;

import com.epam.az.xml.entity.Flowers;


public interface XmlParser {
    Object parseXml(Class rootClass, String rootList,String path);

}
