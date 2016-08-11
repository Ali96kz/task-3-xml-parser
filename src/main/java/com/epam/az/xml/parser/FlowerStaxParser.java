package com.epam.az.xml.parser;

import com.epam.az.xml.entity.FlowerStack;
import com.epam.az.xml.entity.GreenHouse;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class FlowerStaxParser extends FlowersXmlParser {

    @Override
    public GreenHouse parseXml(String path) {
        XMLInputFactory factory = XMLInputFactory.newInstance();
        FlowerStack flowerStack = new FlowerStack();
        GreenHouse greenHouse = new GreenHouse();
        try {
            XMLEventReader eventReader = factory.createXMLEventReader(new FileReader(path));
            while (eventReader.hasNext()) {
                XMLEvent event = eventReader.nextEvent();
                switch (event.getEventType()) {
                    case XMLStreamConstants.START_ELEMENT:
                        StartElement startElement = event.asStartElement();
                        String qName = startElement.getName().getLocalPart();
                        elementStart(flowerStack, qName);
                        break;
                    case XMLStreamConstants.CHARACTERS:
                        Characters characters = event.asCharacters();
                        chars(characters.getData());
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        EndElement endElement = event.asEndElement();
                        elementEnd(flowerStack, endElement.getName().getLocalPart(), greenHouse);
                        break;
                }
            }
        } catch (XMLStreamException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}
