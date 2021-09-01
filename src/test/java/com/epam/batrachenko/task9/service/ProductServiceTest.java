package com.epam.batrachenko.task9.service;

import com.epam.batrachenko.task1.Entity.Product;
import com.epam.batrachenko.task3.List.UniqueProductArrayList;
import com.epam.batrachenko.task9.repository.ProductRepository;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ProductServiceTest {
    private UniqueProductArrayList<Product> listProduct = new UniqueProductArrayList<>();

    {
        listProduct.add(new Product("prod1", new BigDecimal("10"), "UK"));
        listProduct.add(new Product("prod2", new BigDecimal("12"), "UK"));
        listProduct.add(new Product("p521", new BigDecimal("15"), "UK"));
    }

    @Test
    public void shouldCorrectlyReturnCountOfItems() {
        String expected = "3";
        ProductRepository repository = mock(ProductRepository.class);
        when(repository.getListProducts()).thenReturn(listProduct);

        String actual = new ProductService(repository).getCountProducts();
        Assert.assertEquals(expected, actual);
    }
}