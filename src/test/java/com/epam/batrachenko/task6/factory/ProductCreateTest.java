package com.epam.batrachenko.task6.factory;

import com.epam.batrachenko.task1.Entity.Accessories;
import com.epam.batrachenko.task1.Entity.ComputerPart;
import com.epam.batrachenko.task1.Entity.GraphicsCard;
import com.epam.batrachenko.task1.Entity.Product;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class ProductCreateTest {
    @Test
    public void shouldCorrectlyCreateProductFromLine() {
        Product expectedProduct = new Product("productTest", new BigDecimal("10"), "test");
        Product actualProduct = (new ProductCreate()).createProductFromString(expectedProduct.toString());
        Assert.assertEquals(expectedProduct, actualProduct);
    }

    @Test
    public void shouldCorrectlyCreateAccessoriesFromLine() {
        Accessories expectedProduct = new Accessories("productTest", new BigDecimal("10"), "test", "type", "brand");
        Product actualProduct = (new AccessoriesCreate()).createProductFromString(expectedProduct.toString());
        Assert.assertEquals(expectedProduct, actualProduct);
    }

    @Test
    public void shouldCorrectlyCreateComputerPartFromLine() {
        ComputerPart expectedProduct = new ComputerPart("productTest", new BigDecimal("10"), "test", "category", "purpose");
        Product actualProduct = (new ComputerPartCreate()).createProductFromString(expectedProduct.toString());
        Assert.assertEquals(expectedProduct, actualProduct);
    }

    @Test
    public void shouldCorrectlyCreateGraphicsCardFromLine() {
        GraphicsCard expectedProduct = new GraphicsCard("productTest", new BigDecimal("10"), "test", "category", "purpose", 1, "memoryType", "connector");
        Product actualProduct = (new GraphicsCardCreate()).createProductFromString(expectedProduct.toString());
        Assert.assertEquals(expectedProduct, actualProduct);
    }
}