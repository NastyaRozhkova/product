package com.epam.batrachenko.task3.HashCodeWrappers;

import com.epam.batrachenko.task1.Entity.Product;
import com.epam.batrachenko.task1.List.ProductArrayList;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class MapIteratorSequenceTest {
    @Test
    public void shouldSequenceDependOnStringElementsInHashMap() {
        HashMap<StringSumElementsHashCodeWrapper, Product> map = new HashMap<>();

        map.put(new StringSumElementsHashCodeWrapper("pro3"), new Product("test", new BigDecimal("2"), "country1"));
        map.put(new StringSumElementsHashCodeWrapper("pro6"), new Product("test", new BigDecimal("3"), "country1"));
        map.put(new StringSumElementsHashCodeWrapper("pro0"), new Product("test", new BigDecimal("1"), "country1"));

        ProductArrayList<Product> products = new ProductArrayList<>();
        for (Product el : map.values()) {
            products.add(el);
        }

        Assert.assertArrayEquals(new Product[]{new Product("test", new BigDecimal("1"), "country1"),
                new Product("test", new BigDecimal("2"), "country1"),
                new Product("test", new BigDecimal("3"), "country1")}, products.toArray());
    }

    @Test
    public void shouldSequenceDependOnStringLengthInHashMap() {
        HashMap<StringLengthHashCodeWrapper, Product> map = new HashMap<>();

        map.put(new StringLengthHashCodeWrapper("prof"), new Product("test", new BigDecimal("1"), "country1"));
        map.put(new StringLengthHashCodeWrapper("proi2"), new Product("test", new BigDecimal("3"), "country1"));
        map.put(new StringLengthHashCodeWrapper("pro0"), new Product("test", new BigDecimal("2"), "country1"));
        map.put(new StringLengthHashCodeWrapper("pro333"), new Product("test", new BigDecimal("4"), "country1"));

        ProductArrayList<Product> products = new ProductArrayList<>();
        for (Product el : map.values()) {
            products.add(el);
        }

        Assert.assertArrayEquals(new Product[]{new Product("test", new BigDecimal("1"), "country1"),
                new Product("test", new BigDecimal("2"), "country1"),
                new Product("test", new BigDecimal("3"), "country1"),
                new Product("test", new BigDecimal("4"), "country1")}, products.toArray());
    }

    @Test
    public void shouldSequenceNotDependOnStringLengthInLinkedHashMap() {
        LinkedHashMap<StringLengthHashCodeWrapper, Product> map = new LinkedHashMap<>();

        map.put(new StringLengthHashCodeWrapper("prof"), new Product("test", new BigDecimal("1"), "country1"));
        map.put(new StringLengthHashCodeWrapper("proi2"), new Product("test", new BigDecimal("2"), "country1"));
        map.put(new StringLengthHashCodeWrapper("pro0"), new Product("test", new BigDecimal("3"), "country1"));

        ProductArrayList<Product> products = new ProductArrayList<>();
        for (Product el : map.values()) {
            products.add(el);
        }

        Assert.assertArrayEquals(new Product[]{new Product("test", new BigDecimal("1"), "country1"),
                new Product("test", new BigDecimal("2"), "country1"),
                new Product("test", new BigDecimal("3"), "country1")}, products.toArray());
    }

    @Test
    public void shouldSequenceNotDependOnStringElementsInLinkedHashMap() {
        LinkedHashMap<StringSumElementsHashCodeWrapper, Product> map = new LinkedHashMap<>();

        map.put(new StringSumElementsHashCodeWrapper("pro3"), new Product("test", new BigDecimal("2"), "country1"));
        map.put(new StringSumElementsHashCodeWrapper("pro6"), new Product("test", new BigDecimal("3"), "country1"));
        map.put(new StringSumElementsHashCodeWrapper("pro0"), new Product("test", new BigDecimal("1"), "country1"));

        ProductArrayList<Product> products = new ProductArrayList<>();
        for (Product el : map.values()) {
            products.add(el);
        }

        Assert.assertArrayEquals(new Product[]{new Product("test", new BigDecimal("2"), "country1"),
                new Product("test", new BigDecimal("3"), "country1"),
                new Product("test", new BigDecimal("1"), "country1")}, products.toArray());

    }
}