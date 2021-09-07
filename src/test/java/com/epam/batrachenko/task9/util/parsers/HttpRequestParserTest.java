package com.epam.batrachenko.task9.util.parsers;

import com.epam.batrachenko.task9.util.Constants;
import com.epam.batrachenko.task9.util.Parser;
import org.junit.Assert;
import org.junit.Test;

public class HttpRequestParserTest {

    @Test
    public void shouldCorrectlyParseNameItemFromRequest() {
        String expected = "product1";
        String actual = Parser.parseFromRequest(Constants.HTTP_GET_PRODUCT_NAME, 2, "GET /shop/item?get_info=product1 ");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldCorrectlyParseGetItemFromRequest() {
        String expected = "/shop/item";
        String actual = Parser.parseFromRequest(Constants.HTTP_GET_COMMAND, 2, "GET /shop/item?get_info=product1");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldCorrectlyParseGetCountFromRequest() {
        String expected = "/shop/count";
        String actual = Parser.parseFromRequest(Constants.HTTP_GET_COMMAND, 2, "GET /shop/count");
        Assert.assertEquals(expected, actual);
    }
}