package com.epam.task8;

public enum CandyEnum {
    CANDY("candy"),
    CHOCOLATE_CANDY("chocolate-candy"),
    LOLLIPOP("lollipop"),
    ID("id"),
    NAME("name"),
    INGREDIENTS("ingredients"),
    COUNTRY("country"),
    APPEARANCE("appearance"),
    CHOCOLATE_PERCENT("chocolate-percent");

    private String value;

    private CandyEnum(String value) {

        this.value = value;
    }

    public String getValue() {

        return value;
    }
}
