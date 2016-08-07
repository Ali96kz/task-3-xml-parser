package com.epam.az.xml.parsers;

import com.epam.az.xml.entity.Flower;
import com.epam.az.xml.entity.GreenHouse;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SaxHandler extends DefaultHandler {
    boolean name, soil, origin, country, province, colorsteam, colorleaves;
    boolean averageHeight, temperature, tmin, tmax, lovelight, waterinweek, wmin, wmax, growingtips;
    private GreenHouse greenHouse = new GreenHouse();
    StringBuilder stringBuilder = new StringBuilder();
    Flower flower = new Flower();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("Name")) {
            String id = attributes.getValue("id");
            flower.setId(Integer.parseInt(id));
            name = true;
        } else if (qName.equalsIgnoreCase("soil")) {
            soil = true;
        } else if (qName.equalsIgnoreCase("origin")) {
            origin = true;
        } else if (qName.equalsIgnoreCase("country")) {
            country = true;
        } else if (qName.equalsIgnoreCase("province")) {
            province = true;
        } else if (qName.equalsIgnoreCase("color-steam")) {
            colorsteam = true;
        } else if (qName.equalsIgnoreCase("color-leaves")) {
            colorleaves = true;
        } else if (qName.equalsIgnoreCase("average-height")) {
            averageHeight = true;
        } else if (qName.equalsIgnoreCase("temperature")) {
            temperature = true;
        } else if (qName.equalsIgnoreCase("water-in-week")) {
            waterinweek = true;
        } else if (qName.equalsIgnoreCase("min")) {
            if (temperature) {
                tmin = true;
            } else
                wmin = true;
        } else if (qName.equalsIgnoreCase("max")) {
            if (temperature) {
                tmax = true;
            } else
                wmax = true;
        } else if (qName.equalsIgnoreCase("lovelight")) {
            lovelight = true;
        } else if (qName.equalsIgnoreCase("growing-tips")) {
            growingtips = true;
        }

    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (name) {
            flower.setName(new String(ch, start, length));
            name = false;
        } else if (soil) {
            soil = false;
        } else if (origin) {
            origin = false;
        } else if (country) {
            country = false;
        } else if (province) {
            province = false;
        } else if (colorsteam) {
            colorsteam = false;
        } else if (colorleaves) {
            colorleaves = false;
        } else if (averageHeight) {
            averageHeight = false;
        } else if (temperature) {
            temperature = false;
        } else if (waterinweek) {
            waterinweek = false;
        } else if (tmin) {
            tmin = false;
        } else if (tmax) {
            tmax = false;
        } else if (lovelight) {
            lovelight = false;
        } else if (growingtips) {
            growingtips = false;
        } else if (wmax) {
            wmax = false;
        } else if (wmin) {
            wmin = false;
        }

    }
}
