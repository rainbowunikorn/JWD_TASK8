package com.epam.task8.parser;

import com.epam.task8.LollipopType;
import com.epam.task8.model.AbstractCandy;
import com.epam.task8.model.ChocolateCandy;
import com.epam.task8.model.Lollipop;
import com.epam.task8.parser.DOM.DOMParser;
import org.junit.Assert;
import org.junit.Test;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class DOMParserTest {

    public static final String FILE_CANDY_TEST_XML = "src/test/resources/CandyTest.xml";
    public static final String INVALID_XML = "src/test/resources/invalid.xml";

    @Test
    public void testDOMParserShouldReturnCandyListWhenXMLFileExists() throws JAXBException, FileNotFoundException {
        //given
        Parser domParser = new DOMParser();

        List<AbstractCandy> excepted = new ArrayList<>();
        excepted.add(new ChocolateCandy(1, "CocoNut", "coconut", "Italy", 50));
        excepted.add(new Lollipop(2, "Mint", "syrup", "Canada", LollipopType.STICK));

        //when
        List<AbstractCandy> actual = domParser.parse(FILE_CANDY_TEST_XML);
        //then
        Assert.assertEquals(excepted, actual);
    }

    @Test
    public void testDOMParserShouldReturnEmptyListWhenXMLFileNotExists() throws JAXBException, FileNotFoundException {
        //given
        Parser domParser = new DOMParser();

        //when
        List<AbstractCandy> actual = domParser.parse(INVALID_XML);
    }
}
