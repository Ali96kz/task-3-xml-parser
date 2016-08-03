package com.epam.az.xml.parsers;

import com.epam.az.xml.entity.Flower;
import com.epam.az.xml.entity.GreenHouse;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Parser implements XmlParser {
    public List<Flower> parserFlowers(String filePath){
        List<Flower> flowers = new ArrayList<>();

        try {
            File file = new File(filePath);
            JAXBContext jaxbContext = JAXBContext.newInstance(GreenHouse.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            GreenHouse e = (GreenHouse) jaxbUnmarshaller.unmarshal(file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return flowers;
    }

}
