package com.epam.batrachenko.task9.repository;

import com.epam.batrachenko.task1.Entity.Product;
import com.epam.batrachenko.task3.List.UniqueProductArrayList;
import com.epam.batrachenko.task6.file_handler.ProductContainerFilesHandler;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Optional;

public class ProductRepositoryTest {
    private UniqueProductArrayList<Product> listProduct = new UniqueProductArrayList<>();
    private ProductRepository repository;

    public ProductRepositoryTest() throws IOException {
        listProduct.add(new Product("prod1", new BigDecimal("10"), "UK"));
        listProduct.add(new Product("prod2", new BigDecimal("12"), "UK"));
        listProduct.add(new Product("p521", new BigDecimal("15"), "UK"));
        new ProductContainerFilesHandler().save(listProduct, "testProductRepository.txt");
    }

    @Before
    public void setUp() {
        repository = new ProductRepository("testProductRepository.txt");
    }

    @Test
    public void shouldReturnFoundItemByName() {
        Optional<Product> expected = Optional.ofNullable(listProduct.get(2));
        Optional<Product> actual = repository.getItemByName("p521");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnNullIfItemNotFound() {
        Optional<Product> expected = Optional.empty();
        Optional<Product> actual = repository.getItemByName("p522");
        Assert.assertEquals(expected, actual);
    }

}