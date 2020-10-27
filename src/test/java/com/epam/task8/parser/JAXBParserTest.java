package com.epam.task8.parser;

import com.epam.task8.LollipopType;
import com.epam.task8.model.AbstractCandy;
import com.epam.task8.model.ChocolateCandy;
import com.epam.task8.model.Lollipop;
import com.epam.task8.parser.JAXB.JAXBParser;
import org.junit.Assert;
import org.junit.Test;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class JAXBParserTest {
    public static final String FILE_CANDY_TEST_XML = "src/test/resources/CandyTest.xml";
    public static final String INVALID_XML = "src/test/resources/invalid.xml";

    @Test
    public void testJAXBParserShouldReturnCandyListWhenXMLFileExists() throws JAXBException, FileNotFoundException {
        //given
        Parser jaxbParser=new JAXBParser();

        List<AbstractCandy> excepted=new ArrayList<>();
        excepted.add(new ChocolateCandy(1, "CocoNut", "coconut", "Italy", 50));
        excepted.add(new Lollipop(2, "Mint", "syrup", "Canada", LollipopType.STICK));

        //when
        List<AbstractCandy> actual = jaxbParser.parse(FILE_CANDY_TEST_XML);

        //then
        Assert.assertEquals(excepted, actual);
    }

    @Test
    public void testJAXBParserShouldReturnEmptyListWhenXMLFileNotExists() throws JAXBException, FileNotFoundException {
        //given
        Parser jaxbParser=new JAXBParser();

        //when
        List<AbstractCandy> actual = jaxbParser.parse(INVALID_XML);
    }
}
