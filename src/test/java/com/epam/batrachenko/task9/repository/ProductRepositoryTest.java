package com.epam.batrachenko.task9.repository;

import com.epam.batrachenko.task1.Entity.Product;
import com.epam.batrachenko.task3.List.UniqueProductArrayList;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Optional;

import static org.mockito.Mockito.*;

public class ProductRepositoryTest {
    private UniqueProductArrayList<Product> listProduct = new UniqueProductArrayList<>();

    {
        listProduct.add(new Product("prod1", new BigDecimal("10"), "UK"));
        listProduct.add(new Product("prod2", new BigDecimal("12"), "UK"));
        listProduct.add(new Product("p521", new BigDecimal("15"), "UK"));
    }

    @Test
    public void shouldReturnFoundItemByName() {
        Optional<Product> expected = Optional.ofNullable(listProduct.get(2));
        ProductRepository repository = spy(ProductRepository.class);
        when(repository.getListProducts()).thenReturn(listProduct);

        Optional<Product> actual = repository.getItemByName("p521");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnNullIfItemNotFound() {
        Optional<Product> expected = Optional.empty();
        ProductRepository repository = spy(ProductRepository.class);
        when(repository.getListProducts()).thenReturn(listProduct);

        Optional<Product> actual = repository.getItemByName("p522");
        Assert.assertEquals(expected, actual);
    }

}