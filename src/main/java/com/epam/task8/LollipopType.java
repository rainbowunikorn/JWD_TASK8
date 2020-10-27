package com.epam.task8;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "LollipopType", namespace = "http://www.example.com/candies")
@XmlEnum()
public enum LollipopType {
    @XmlEnumValue("STICK") STICK,
    @XmlEnumValue("DRAGEE")DRAGEE
}

