package com.epam.batrachenko.task9.repository;

import com.epam.batrachenko.task1.Entity.Product;
import com.epam.batrachenko.task3.List.UniqueProductArrayList;
import com.epam.batrachenko.task6.file_handler.ProductContainerFilesHandler;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Optional;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProductRepositoryTest {
    private UniqueProductArrayList<Product> listProduct = new UniqueProductArrayList<>();
    @InjectMocks
    private ProductRepository repository;

    @Mock
    private ProductContainerFilesHandler filesHandler;

    public ProductRepositoryTest() {
        listProduct.add(new Product("prod1", new BigDecimal("10"), "UK"));
        listProduct.add(new Product("prod2", new BigDecimal("12"), "UK"));
        listProduct.add(new Product("p521", new BigDecimal("15"), "UK"));
    }

    @Before
    public void setUp() throws IOException {
        when(filesHandler.load("")).thenReturn(listProduct);
        repository = new ProductRepository(filesHandler,"");
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