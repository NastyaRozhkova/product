package com.epam.batrachenko.task7.reflection;

import com.epam.batrachenko.task1.Entity.Accessories;
import com.epam.batrachenko.task1.Entity.ComputerPart;
import com.epam.batrachenko.task1.Entity.GraphicsCard;
import com.epam.batrachenko.task1.Entity.Product;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.List;

public class InputProductDataFromConsoleTest {
    private InputStream systemIn;
    private ByteArrayInputStream inputStream;
    private Resource resource = new Resource("en");
    @Before
    public void setUp() {
        systemIn = System.in;
    }

    @After
    public void tearDown() {
        System.setIn(systemIn);
    }

    @Test
    public void shouldCorrectlyInputDataForProduct() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        String data = "1" + System.lineSeparator()+
                "test" + System.lineSeparator() +
                "1" + System.lineSeparator() +
                "test" + System.lineSeparator();
        inputStream = new ByteArrayInputStream(data.getBytes());
        System.setIn(inputStream);

        List<Product> products = new InputProductDataFromConsole().fill(1,resource);
        Product expected = new Product("test", new BigDecimal("1"), "test");

        Assert.assertEquals(expected, products.get(0));
    }

    @Test
    public void shouldCorrectlyInputDataForAccessories() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        String data = "2" + System.lineSeparator() +
                "test" + System.lineSeparator() +
                "1" + System.lineSeparator() +
                "test" + System.lineSeparator() +
                "test" + System.lineSeparator() +
                "test" + System.lineSeparator();
        inputStream = new ByteArrayInputStream(data.getBytes());
        System.setIn(inputStream);

        List<Product> products = new InputProductDataFromConsole().fill(1,resource);
        Product expected = new Accessories("test", new BigDecimal("1"), "test", "test", "test");

        Assert.assertEquals(expected, products.get(0));
    }

    @Test
    public void shouldCorrectlyInputDataForComputerPart() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        String data = "3" + System.lineSeparator() +
                "test" + System.lineSeparator() +
                "1" + System.lineSeparator() +
                "test" + System.lineSeparator() +
                "test" + System.lineSeparator() +
                "test" + System.lineSeparator();
        inputStream = new ByteArrayInputStream(data.getBytes());
        System.setIn(inputStream);

        List<Product> products = new InputProductDataFromConsole().fill(1,resource);
        Product expected = new ComputerPart("test", new BigDecimal("1"), "test", "test", "test");

        Assert.assertEquals(expected, products.get(0));
    }

    @Test
    public void shouldCorrectlyInputDataForGraphicsCard() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        String data = "4" + System.lineSeparator() +
                "test" + System.lineSeparator() +
                "1" + System.lineSeparator() +
                "test" + System.lineSeparator() +
                "test" + System.lineSeparator() +
                "test" + System.lineSeparator() +
                "1" + System.lineSeparator() +
                "test" + System.lineSeparator() +
                "test" + System.lineSeparator();
        inputStream = new ByteArrayInputStream(data.getBytes());
        System.setIn(inputStream);

        List<Product> products = new InputProductDataFromConsole().fill(1,resource);
        Product expected = new GraphicsCard("test", new BigDecimal("1"), "test", "test", "test", 1, "test", "test");

        Assert.assertEquals(expected, products.get(0));
    }
}