package com.epam.task8.parser.SAX;

import com.epam.task8.CandyEnum;
import com.epam.task8.LollipopType;
import com.epam.task8.model.AbstractCandy;
import com.epam.task8.model.ChocolateCandy;
import com.epam.task8.model.Lollipop;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class CandyHandler extends DefaultHandler {

    private List<AbstractCandy> candies;
    private AbstractCandy candy;
    private StringBuilder data;

    public List<AbstractCandy> getCandies() {
        return candies;
    }

    boolean flagName = false;
    boolean flagIngredient = false;
    boolean flagCountry = false;
    boolean flagChocolatePercent = false;
    boolean flagAppearance = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        if (qName.equalsIgnoreCase("chocolate-candy")) {
            String id = attributes.getValue("id");

            candy = new ChocolateCandy();
            candy.setId(Integer.parseInt(id));

            if (candies == null)
                candies = new ArrayList<>();
        } else if (qName.equalsIgnoreCase("lollipop")) {
            String id = attributes.getValue("id");

            candy = new Lollipop();
            candy.setId(Integer.parseInt(id));
            if (candies == null)
                candies = new ArrayList<>();
        }
        if (qName.equalsIgnoreCase("name")) {
            flagName = true;
        } else if (qName.equalsIgnoreCase("ingredients")) {
            flagIngredient = true;
        } else if (qName.equalsIgnoreCase("country")) {
            flagCountry = true;
        } else if (qName.equalsIgnoreCase("chocolate-percent")) {
            flagChocolatePercent = true;
        } else if (qName.equalsIgnoreCase("appearance")) {
            flagAppearance = true;
        }
        data = new StringBuilder();
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (flagName) {
            candy.setName(data.toString());
            flagName = false;
        } else if (flagIngredient) {
            candy.setIngredient(data.toString());
            flagIngredient = false;
        } else if (flagCountry) {
            candy.setCountry(data.toString());
            flagCountry = false;
        } else if (flagChocolatePercent) {
            ((ChocolateCandy) candy).setChocolatePercent(Integer.parseInt(data.toString()));
            flagChocolatePercent = false;
        } else if (flagAppearance) {
            ((Lollipop) candy).setAppearance(LollipopType.valueOf(data.toString().toUpperCase()));
            flagAppearance = false;
        }
        if (qName.equalsIgnoreCase(CandyEnum.CHOCOLATE_CANDY.getValue()) || qName.equalsIgnoreCase(CandyEnum.LOLLIPOP.getValue())) {
            candies.add(candy);
        }
    }

    @Override
    public void characters(char ch[], int start, int length) throws SAXException {
        data.append(new String(ch, start, length));
    }
}
