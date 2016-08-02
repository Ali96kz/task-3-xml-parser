package com.epam.az.xml.entity;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "person")
@XmlType(propOrder = {"name","soil","origin"})
public class Flower {
    private String name;
    private String soil;
    private String origin;
    private String visualParametrs;
    private String growingTips;
}
