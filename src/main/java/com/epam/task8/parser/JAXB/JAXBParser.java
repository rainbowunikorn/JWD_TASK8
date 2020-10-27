package com.epam.task8.parser.JAXB;

import com.epam.task8.model.AbstractCandy;
import com.epam.task8.model.CandyStorage;
import com.epam.task8.parser.Parser;
import org.apache.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
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

            JAXBContext context = JAXBContext.newInstance(CandyStorage.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            reader = new FileReader(file);
            CandyStorage candies = (CandyStorage) unmarshaller.unmarshal(reader);
            return candies.getCandyStorage();

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
