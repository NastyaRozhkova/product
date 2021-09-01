package com.epam.batrachenko.task9.util.parsers;

import org.junit.Assert;
import org.junit.Test;

public class TcpRequestParserTest {
    private TcpRequestParser parser = new TcpRequestParser();

    @Test
    public void shouldCorrectlyParseNameItemFromRequest() {
        String expected = "product1";
        String actual = parser.parseNameItemFromRequest("get item=product1\n");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldCorrectlyParseGetItemFromRequest() {
        String expected = "get item";
        String actual = parser.parseNameCommandFromRequest("get item=product1\n");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldCorrectlyParseGetCountFromRequest() {
        String expected = "get count";
        String actual = parser.parseNameCommandFromRequest("get count\n");
        Assert.assertEquals(expected, actual);
    }
}