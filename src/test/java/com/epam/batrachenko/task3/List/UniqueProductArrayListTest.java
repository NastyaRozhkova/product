package com.epam.batrachenko.task3.List;

import com.epam.batrachenko.task1.Entity.Product;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class UniqueProductArrayListTest {

    @Test
    public void shouldAddProduct() {
        UniqueProductArrayList<Product> products = new UniqueProductArrayList<>();

        products.add(new Product("test", new BigDecimal("10"), "uk"));
        products.add(new Product("test", new BigDecimal("11"), "uk"));

        Assert.assertArrayEquals(new Product[]{new Product("test", new BigDecimal("10"), "uk"), new Product("test", new BigDecimal("11"), "uk")}, products.toArray());
    }

    @Test
    public void shouldNotAddDuplicateProduct() {
        UniqueProductArrayList<Product> products = new UniqueProductArrayList<>();

        products.add(new Product("test", new BigDecimal("10"), "uk"));
        products.add(new Product("test", new BigDecimal("10"), "uk"));

        Assert.assertArrayEquals(new Product[]{new Product("test", new BigDecimal("10"), "uk")}, products.toArray());
    }

    @Test
    public void shouldAddProductByIndex() {
        UniqueProductArrayList<Product> products = new UniqueProductArrayList<>();

        products.add(0, new Product("test", new BigDecimal("10"), "uk"));
        products.add(1, new Product("test", new BigDecimal("11"), "uk"));

        Assert.assertArrayEquals(new Product[]{new Product("test", new BigDecimal("10"), "uk"), new Product("test", new BigDecimal("11"), "uk")}, products.toArray());
    }

    @Test
    public void shouldNotAddProductDuplicateByIndex() {
        UniqueProductArrayList<Product> products = new UniqueProductArrayList<>();

        products.add(0, new Product("test", new BigDecimal("10"), "uk"));
        products.add(1, new Product("test", new BigDecimal("10"), "uk"));

        Assert.assertArrayEquals(new Product[]{new Product("test", new BigDecimal("10"), "uk")}, products.toArray());
    }

    @Test
    public void shouldSetProduct() {
        UniqueProductArrayList<Product> products = new UniqueProductArrayList<>();

        products.add(0, new Product("test", new BigDecimal("10"), "uk"));
        products.add(1, new Product("test", new BigDecimal("11"), "uk"));
        products.set(1, new Product("test", new BigDecimal("12"), "uk"));

        Assert.assertArrayEquals(new Product[]{new Product("test", new BigDecimal("10"), "uk"), new Product("test", new BigDecimal("12"), "uk")}, products.toArray());
    }

    @Test
    public void shouldNotSetDuplicateProduct() {
        UniqueProductArrayList<Product> products = new UniqueProductArrayList<>();

        products.add(0, new Product("test", new BigDecimal("10"), "uk"));
        products.add(1, new Product("test", new BigDecimal("11"), "uk"));
        products.set(1, new Product("test", new BigDecimal("10"), "uk"));

        Assert.assertArrayEquals(new Product[]{new Product("test", new BigDecimal("10"), "uk"), new Product("test", new BigDecimal("11"), "uk")}, products.toArray());
    }

    @Test
    public void shouldCorrectReplaceAllProduct() {
        UniqueProductArrayList<Product> products = new UniqueProductArrayList<>();

        products.add(0, new Product("test", new BigDecimal("10"), "uk"));
        products.add(1, new Product("test", new BigDecimal("11"), "uk"));
        products.replaceAll(p -> {
            p.setPrice(p.getPrice().add(new BigDecimal("1")));
            return p;
        });

        Assert.assertArrayEquals(new Product[]{new Product("test", new BigDecimal("10"), "uk"), new Product("test", new BigDecimal("12"), "uk")}, products.toArray());
    }
}