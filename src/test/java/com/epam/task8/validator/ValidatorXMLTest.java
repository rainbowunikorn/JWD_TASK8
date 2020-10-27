package com.epam.task8.validator;

import org.junit.Assert;
import org.junit.Test;
import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

public class ValidatorXMLTest {
    public static final String FILE_CANDY_TEST_XML = "Candy.xml";
    public static final String FILE_CANDY_TEST_XSD="Candy.xsd";
    public static final String INVALID_XML = "src/test/resources/invalid.xml";

    @Test
    public void testValidatorXMLShouldReturnTrueWhenXMLFileValid() throws JAXBException, FileNotFoundException {
        //given
        ValidatorXML validatorXML=new ValidatorXML(FILE_CANDY_TEST_XSD);

        //when
        boolean actual= validatorXML.valid(FILE_CANDY_TEST_XML);

        //then
        Assert.assertEquals(true, actual);
    }

    @Test
    public void testValidatorXMLShouldReturnFalseWhenXMLFileIsNotValid() throws JAXBException, FileNotFoundException {
        //given
        ValidatorXML validatorXML=new ValidatorXML(FILE_CANDY_TEST_XSD);
        //when
        boolean actual= validatorXML.valid(INVALID_XML);

        //then
        Assert.assertEquals(false, actual);
    }
}
