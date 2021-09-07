package com.epam.batrachenko.task9.util.parsers;

import com.epam.batrachenko.task9.util.Constants;
import com.epam.batrachenko.task9.util.Parser;
import org.junit.Assert;
import org.junit.Test;

public class TcpRequestParserTest {

    @Test
    public void shouldCorrectlyParseNameItemFromRequest() {
        String expected = "product1";
        String actual = Parser.parseFromRequest(Constants.TCP_GET_PRODUCT_NAME,2,"get item=product1\n");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldCorrectlyParseGetItemFromRequest() {
        String expected = "get item";
        String actual = Parser.parseFromRequest(Constants.TCP_GET_COMMAND,1,"get item=product1\n");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldCorrectlyParseGetCountFromRequest() {
        String expected = "get count";
        String actual = Parser.parseFromRequest(Constants.TCP_GET_COMMAND,1,"get count\n");
        Assert.assertEquals(expected, actual);
    }
}