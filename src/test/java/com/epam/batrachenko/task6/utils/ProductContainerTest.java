package com.epam.batrachenko.task6.utils;

import com.epam.batrachenko.task1.Entity.Product;
import com.epam.batrachenko.task5.read_file_wrappers.ReadTextFileWrapper;
import com.epam.batrachenko.task6.file_handler.ProductContainerFilesHandler;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class ProductContainerTest {
    private File file;

    @Before
    public void setUp() throws Exception {
        this.file = new File("serializationTest.txt");
        this.file.createNewFile();
        RandomAccessFile raf = new RandomAccessFile(this.file, "rw");
        raf.write((new Product("productTest", new BigDecimal("10"), "test")).toString().getBytes(StandardCharsets.UTF_8));
        raf.close();
    }

    @After
    public void tearDown() {
        this.file.delete();
    }

    @Test
    public void shouldLoadDataFromFile() throws IOException {
        List<Product> actual = new ProductContainerFilesHandler().load("serializationTest.txt");
        Product[] expected = new Product[]{new Product("productTest", new BigDecimal("10"), "test")};
        Assert.assertArrayEquals(expected, actual.toArray());
    }

    @Test
    public void shouldSaveDataToFile() throws IOException {
        List<Product> products = new ArrayList<>();
        products.add(new Product("productTest2", new BigDecimal("10"), "test"));
        new ProductContainerFilesHandler().save(products, "serializationTest.txt");

        StringBuilder actual = new StringBuilder();
        try (ReadTextFileWrapper file = new ReadTextFileWrapper("serializationTest.txt")) {
            for (String line : file) {
                actual.append(line);
            }
        }
        String expected = (new Product("productTest2", new BigDecimal("10"), "test")).toString();

        Assert.assertEquals(expected, actual.toString());
    }
}
