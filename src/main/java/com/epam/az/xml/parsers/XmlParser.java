package com.epam.az.xml.parsers;

import java.io.File;

public interface XmlParser {
    String parseFile(File file);
    String parseFile(String path);
    String parseWeb(String url);

}
