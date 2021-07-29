package com.epam.batrachenko.task2.Iterator;

import com.epam.batrachenko.task1.Entity.Product;
import com.epam.batrachenko.task1.List.ProductArrayList;
import com.epam.batrachenko.task2.List.UnmodifiableModifiableProductList;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class UnmodifiableModifiableProductListIteratorTest {

    @Test
    public void shouldCorrectlyWorkIteratorInForEach() {
        ProductArrayList<Product> unmodifiableProducts = new ProductArrayList<>();

        unmodifiableProducts.add(new Product("test", new BigDecimal("10"), "uk"));
        unmodifiableProducts.add(new Product("test", new BigDecimal("11"), "uk"));

        ProductArrayList<Product> modifiableProducts = new ProductArrayList<>();

        modifiableProducts.add(new Product("test", new BigDecimal("12"), "uk"));
        modifiableProducts.add(new Product("test", new BigDecimal("13"), "uk"));

        UnmodifiableModifiableProductList<Product> products = new UnmodifiableModifiableProductList<>(unmodifiableProducts, modifiableProducts);

        ProductArrayList<Product> newProducts = new ProductArrayList<>();

        for (Product temp : products) {
            newProducts.add(temp);
        }

        ProductArrayList<Product> expectedProducts = products.getList();

        Assert.assertArrayEquals(expectedProducts.toArray(), newProducts.toArray());
    }
}