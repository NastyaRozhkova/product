package com.epam.batrachenko.task7.proxy.factory.products;

import com.epam.batrachenko.task7.proxy.factory.creators.ProductOnMapCreator;
import com.epam.batrachenko.task7.proxy.factory.creators.UnmodifiableProductCreator;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class ProductProxyTest {
    @Test
    public void shouldSetAndGetFieldsInProductOnMap() {
        ProductMethods actualProduct = new ProductOnMapCreator().createProxyProduct();
        actualProduct.setName("test1");
        actualProduct.setCountry("test1");
        actualProduct.setPrice(new BigDecimal("1"));

        Assert.assertEquals("test1", actualProduct.getName());
        Assert.assertEquals("test1", actualProduct.getCountry());
        Assert.assertEquals(new BigDecimal("1"), actualProduct.getPrice());
    }

    @Test
    public void shouldNotSetFieldsInUnmodifiableProduct() {
        ProductMethods actualProduct = new UnmodifiableProductCreator().createProxyProduct();
        Assert.assertThrows(UnsupportedOperationException.class, () -> actualProduct.setName("test1"));
        Assert.assertThrows(UnsupportedOperationException.class, () -> actualProduct.setCountry("test1"));
        BigDecimal price = new BigDecimal("1");
        Assert.assertThrows(UnsupportedOperationException.class, () -> actualProduct.setPrice(price));
    }

    @Test
    public void shouldGetFieldsInUnmodifiableProduct() {
        ProductMethods actualProduct = new UnmodifiableProductCreator().createProxyProduct();
        Assert.assertEquals("test1", actualProduct.getName());
        Assert.assertEquals("test1", actualProduct.getCountry());
        Assert.assertEquals(new BigDecimal("1"), actualProduct.getPrice());
    }
}