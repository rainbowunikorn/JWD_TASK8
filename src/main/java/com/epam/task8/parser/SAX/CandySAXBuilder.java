package com.epam.task8.parser.SAX;

import com.epam.task8.model.AbstractCandy;
import com.epam.task8.parser.Parser;
import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class CandySAXBuilder implements Parser {

    public static final Logger log = Logger.getLogger(CandySAXBuilder.class);

    @Override
    public List<AbstractCandy> parse(String file) throws JAXBException, FileNotFoundException {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            CandyHandler handler = new CandyHandler();
            saxParser.parse(new File(file), handler);
            return handler.getCandies();
        } catch (SAXException | IOException | ParserConfigurationException e) {
            log.info("parser error "+e);
        }
        return null;
    }
}
