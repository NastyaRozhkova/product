package com.epam.batrachenko.task9.util.parsers;

import org.junit.Assert;
import org.junit.Test;

public class HttpRequestParserTest {
    private HttpRequestParser parser = new HttpRequestParser();

    @Test
    public void shouldCorrectlyParseNameItemFromRequest() {
        String expected = "product1";
        String actual = parser.parseNameFromRequest("GET /shop/item?get_info=product1 ");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldCorrectlyParseGetItemFromRequest() {
        String expected = "/shop/item";
        String actual = parser.parseNameCommandFromRequest("GET /shop/item?get_info=product1");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldCorrectlyParseGetCountFromRequest() {
        String expected = "/shop/count";
        String actual = parser.parseNameCommandFromRequest("GET /shop/count");
        Assert.assertEquals(expected, actual);
    }
}