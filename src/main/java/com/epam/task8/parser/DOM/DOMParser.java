package com.epam.task8.parser.DOM;

import com.epam.task8.CandyEnum;
import com.epam.task8.LollipopType;
import com.epam.task8.model.AbstractCandy;
import com.epam.task8.model.ChocolateCandy;
import com.epam.task8.model.Lollipop;
import com.epam.task8.parser.Parser;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DOMParser implements Parser {
    public static final String CHOCOLATE_CANDY_ATTRIBUTE = "chocolate-candy";
    public static final String LOLLIPOP_ATTRIBUTE = "lollipop";

    private final List<AbstractCandy> candies;
    private DocumentBuilder docBuilder;

    private static final Logger log = Logger.getLogger(DOMParser.class);

    //create a java dom xml parser
    public DOMParser() {
        this.candies = new ArrayList<>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            docBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            log.warn("parser error " + e);
        }
    }

    private void fillCandyList(CandyEnum candyType, String attribute, Document doc) {

        //DOM Elements, Child elements
        NodeList nodeList = doc.getElementsByTagName(attribute);

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element child = (Element) node;

                int id = Integer.parseInt(child.getAttribute(CandyEnum.ID.getValue()));

                String name = child.getElementsByTagName(CandyEnum.NAME.getValue())
                        .item(0)
                        .getTextContent();

                String ingredients = child.getElementsByTagName(CandyEnum.INGREDIENTS.getValue())
                        .item(0)
                        .getTextContent();

                String country = child.getElementsByTagName(CandyEnum.COUNTRY.getValue())
                        .item(0)
                        .getTextContent();

                switch (candyType) {
                    case CHOCOLATE_CANDY:
                        int chocolatePercent = Integer.parseInt(child.getElementsByTagName(CandyEnum.CHOCOLATE_PERCENT.getValue())
                                .item(0)
                                .getTextContent());
                        ChocolateCandy chocolateCandy = new ChocolateCandy(id, name, ingredients, country, chocolatePercent);
                        candies.add(chocolateCandy);
                        log.info("element "+chocolateCandy.toString()+" added successfully");
                        break;
                    case LOLLIPOP:
                        LollipopType lollipopType = LollipopType.valueOf(child.getElementsByTagName(CandyEnum.APPEARANCE.getValue())
                                .item(0)
                                .getTextContent().toUpperCase());
                        Lollipop lollipop = new Lollipop(id, name, ingredients, country, lollipopType);
                        candies.add(lollipop);
                        log.info("element "+lollipop.toString()+" added successfully");
                        break;
                }

            }
        }
    }

    @Override
    public List<AbstractCandy> parse(String file) {
        try {
            File inputFile = new File(file);
            Document doc = docBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            //the root element
            String rootElement = doc.getDocumentElement().getNodeName();
            log.info("root element: " + rootElement);

            fillCandyList(CandyEnum.CHOCOLATE_CANDY, CHOCOLATE_CANDY_ATTRIBUTE, doc);
            fillCandyList(CandyEnum.LOLLIPOP, LOLLIPOP_ATTRIBUTE, doc);

        } catch (IOException | SAXException e) {
            log.warn("file parser error" + e);
        }
        return candies;
    }
}
