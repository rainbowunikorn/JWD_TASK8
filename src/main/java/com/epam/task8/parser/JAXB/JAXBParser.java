package com.epam.task8.parser.JAXB;

import com.epam.task8.model.AbstractCandy;
import com.epam.task8.model.Candies;
import com.epam.task8.parser.Parser;
import org.apache.log4j.Logger;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.SchemaFactory;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class JAXBParser implements Parser {
    private static final Logger log = Logger.getLogger(JAXBParser.class);

    @Override
    public List<AbstractCandy> parse(String file) {
        FileReader reader = null;
        try {

            JAXBContext context = JAXBContext.newInstance(Candies.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            reader = new FileReader(file);
            Candies candies = (Candies) unmarshaller.unmarshal(reader);
            return candies.getCandies();

        } catch (JAXBException | FileNotFoundException e) {
            log.warn("parser error " + e);
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    log.error(e.getMessage(), e);
                }
            }
        }
        return null;
    }
}
