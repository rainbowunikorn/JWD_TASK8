package com.epam.task8.parser;
import com.epam.task8.model.AbstractCandy;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.util.List;

public interface Parser {
    List<AbstractCandy> parse(String file) throws JAXBException, FileNotFoundException;

}
