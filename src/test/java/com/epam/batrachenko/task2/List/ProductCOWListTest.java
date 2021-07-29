package com.epam.batrachenko.task2.List;

import com.epam.batrachenko.task1.Entity.Product;
import com.epam.batrachenko.task1.List.ProductArrayList;
import com.epam.batrachenko.task2.List.ProductCOWList;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class ProductCOWListTest {
    @Test
    public void shouldAddProduct() {
        ProductArrayList<Product> products = new ProductArrayList<>();

        products.add(new Product("test", new BigDecimal("10"), "uk"));
        products.add(new Product("test", new BigDecimal("11"), "uk"));

        ProductCOWList<Product> productCOWList = new ProductCOWList<>(products);
        productCOWList.add(new Product("test", new BigDecimal("12"), "uk"));

        Assert.assertEquals(new Product("test", new BigDecimal("12"), "uk"),productCOWList.get(2));
      }

    @Test
    public void shouldRemoveProduct() {
        ProductArrayList<Product> products = new ProductArrayList<>();

        products.add(new Product("test", new BigDecimal("10"), "uk"));
        products.add(new Product("test", new BigDecimal("11"), "uk"));

        ProductCOWList<Product> productCOWList = new ProductCOWList<>(products);
        productCOWList.remove(1);

        Assert.assertEquals(productCOWList.size(),1);
        Assert.assertEquals(productCOWList.get(0),new Product("test", new BigDecimal("10"), "uk"));
    }

    @Test
    public void shouldSetProduct() {
        ProductArrayList<Product> products = new ProductArrayList<>();

        products.add(new Product("test", new BigDecimal("10"), "uk"));
        products.add(new Product("test", new BigDecimal("11"), "uk"));

        ProductCOWList<Product> productCOWList = new ProductCOWList<>(products);
        productCOWList.set(1,new Product("test", new BigDecimal("12"), "uk"));

        Assert.assertEquals(new Product("test", new BigDecimal("12"), "uk"),productCOWList.get(1));
    }
}