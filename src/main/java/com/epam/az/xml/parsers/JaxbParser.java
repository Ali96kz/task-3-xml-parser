package com.epam.az.xml.parsers;

import com.epam.az.xml.entity.Flower;
import com.epam.az.xml.entity.GreenHouse;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class JaxbParser implements XmlParser {

    @Override
    public GreenHouse parseXml(String filePath) {
        GreenHouse greenHouse  = null;
        try {
            File file = new File(filePath);
            JAXBContext jaxbContext = JAXBContext.newInstance(GreenHouse.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            greenHouse = (GreenHouse) jaxbUnmarshaller.unmarshal(file);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return greenHouse;
    }

}
