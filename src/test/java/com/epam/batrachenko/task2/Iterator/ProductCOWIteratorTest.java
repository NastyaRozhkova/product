package com.epam.batrachenko.task2.Iterator;

import com.epam.batrachenko.task1.Entity.Product;
import com.epam.batrachenko.task1.List.ProductArrayList;
import com.epam.batrachenko.task2.List.ProductCOWList;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Iterator;

public class ProductCOWIteratorTest {
    @Test
    public void shouldCorrectlyWorkInForEachIfAddProducts(){
        ProductCOWList<Product> products=new ProductCOWList<>();

        products.add(0, new Product("test", new BigDecimal("10"), "uk"));
        products.add(0, new Product("test", new BigDecimal("13"), "uk"));

        ProductCOWList<Product> expectedProducts=new ProductCOWList<>(products);
        ProductArrayList<Product> newProducts=new ProductArrayList<>();
        for (Product temp: products) {
            newProducts.add(temp);
            products.add(new Product("test", new BigDecimal("13"+temp.getPrice()), "uk"));
        }

        Assert.assertArrayEquals(expectedProducts.toArray(),newProducts.toArray());
    }

    @Test
    public void shouldCorrectlyWorkIfRemoveProducts(){
        ProductCOWList<Product> products=new ProductCOWList<>();

        products.add(0, new Product("test", new BigDecimal("10"), "uk"));
        products.add(0, new Product("test", new BigDecimal("13"), "uk"));

        Iterator<Product> it= products.iterator();

        products.remove(0);
        products.remove(0);

        Assert.assertEquals(new Product("test", new BigDecimal("13"), "uk"), it.next());
    }
}
