package com.epam.batrachenko.task4.Store;

import com.epam.batrachenko.task1.Entity.Product;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCartTest {

    private PrintStream systemOut;
    private final ByteArrayOutputStream data = new ByteArrayOutputStream();

    @Before
    public void setUpStream() {
        systemOut = System.out;
        System.setOut(new PrintStream(data));
    }

    @After
    public void revertStream() {
        System.setOut(systemOut);
    }

    @Test
    public void shouldAddProduct() {
        ShoppingCart sc = new ShoppingCart();
        sc.addProduct(new Product("test", new BigDecimal("10"), "country"));

        Assert.assertArrayEquals(new Product[]{new Product("test", new BigDecimal("10"), "country")},
                sc.getProducts().toArray());
    }

    @Test
    public void shouldPrintShoppingCart() {
        ShoppingCart sc = new ShoppingCart();
        sc.addProduct(new Product("test", new BigDecimal("10"), "country"));
        sc.addProduct(new Product("test2", new BigDecimal("11"), "country"));

        sc.printShoppingCart();

        StringBuilder sb = new StringBuilder();
        sb.append(new Product("test", new BigDecimal("10"), "country").toString())
                .append(System.lineSeparator())
                .append("Count of product:1\n")
                .append(System.lineSeparator())
                .append(new Product("test2", new BigDecimal("11"), "country").toString())
                .append(System.lineSeparator()).append("Count of product:1\n")
                .append(System.lineSeparator());

        Assert.assertEquals(sb.toString(), data.toString());
    }

    @Test
    public void shouldMakeOrder() {
        ShoppingCart sc = new ShoppingCart();
        sc.addProduct(new Product("test", new BigDecimal("10"), "country"));
        sc.addProduct(new Product("test2", new BigDecimal("11"), "country"));
        List<ShoppingCart> expected = new ArrayList<>(ConsoleStore.getInstance().getOrders().values());

        sc.makeOrder();

        sc.addProduct(new Product("test", new BigDecimal("10"), "country"));
        sc.addProduct(new Product("test2", new BigDecimal("11"), "country"));
        expected.add(sc);
        Assert.assertArrayEquals(expected.toArray(), ConsoleStore.getInstance().getOrders().values().toArray());

        Assert.assertEquals("Total price of order is:21" + System.lineSeparator(), data.toString());
    }

    @Test
    public void shouldClearCart() {
        ShoppingCart sc = new ShoppingCart();
        sc.addProduct(new Product("test", new BigDecimal("10"), "country"));

        sc.clearCart();

        Assert.assertEquals(0, sc.getProducts().size());
    }

    @Test
    public void shouldPrintLastFiveProductsIfSizeLessThanFive() {
        ShoppingCart sc = new ShoppingCart();
        sc.addProduct(new Product("test", new BigDecimal("10"), "country"));

        sc.printLastFiveProducts();

        Assert.assertEquals(
                new Product("test", new BigDecimal("10"), "country").toString()
                        + System.lineSeparator(), data.toString());
    }

    @Test
    public void shouldPrintLastFiveProducts() {
        ShoppingCart sc = new ShoppingCart();
        sc.addProduct(new Product("test1", new BigDecimal("10"), "country"));
        sc.addProduct(new Product("test2", new BigDecimal("10"), "country"));
        sc.addProduct(new Product("test3", new BigDecimal("10"), "country"));
        sc.addProduct(new Product("test4", new BigDecimal("10"), "country"));
        sc.addProduct(new Product("test5", new BigDecimal("10"), "country"));
        sc.addProduct(new Product("test6", new BigDecimal("10"), "country"));

        sc.printLastFiveProducts();

        StringBuilder sb = new StringBuilder();
        sb.append(new Product("test2", new BigDecimal("10"), "country")).append(System.lineSeparator())
                .append(new Product("test3", new BigDecimal("10"), "country")).append(System.lineSeparator())
                .append(new Product("test4", new BigDecimal("10"), "country")).append(System.lineSeparator())
                .append(new Product("test5", new BigDecimal("10"), "country")).append(System.lineSeparator())
                .append(new Product("test6", new BigDecimal("10"), "country")).append(System.lineSeparator());

        Assert.assertEquals(sb.toString(), data.toString());
    }
}