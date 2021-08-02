package com.epam.batrachenko.task4.services;

import com.epam.batrachenko.task1.Entity.Product;
import com.epam.batrachenko.task4.repository.ConsoleStore;
import com.epam.batrachenko.task4.repository.ShoppingCart;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CartServiceTest {
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
    public void shouldMakeOrder() {
        ConsoleStore store = new ConsoleStore();
        CartService sc = new CartService(new ShoppingCart(), store);
        sc.addProduct(new Product("test", new BigDecimal("10"), "country"));
        sc.addProduct(new Product("test2", new BigDecimal("11"), "country"));

        BigDecimal price = sc.makeOrder();

        sc.addProduct(new Product("test", new BigDecimal("10"), "country"));
        sc.addProduct(new Product("test2", new BigDecimal("11"), "country"));
        List<ShoppingCart> expected = new ArrayList<>();
        expected.add(sc.getShoppingCart());

        Assert.assertArrayEquals(expected.toArray(), store.getOrders().values().toArray());

        Assert.assertEquals(new BigDecimal("21"), price);
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
        CartService cart=new CartService(new ShoppingCart(),new ConsoleStore());
        cart.addProduct(new Product("test", new BigDecimal("10"), "country"));

        cart.getLastFiveProducts().forEach(System.out::println);

        Assert.assertEquals(
                new Product("test", new BigDecimal("10"), "country").toString()
                        + System.lineSeparator(), data.toString());
    }

    @Test
    public void shouldPrintLastFiveProducts() {
        CartService cart=new CartService(new ShoppingCart(),new ConsoleStore());
        cart.addProduct(new Product("test1", new BigDecimal("10"), "country"));
        cart.addProduct(new Product("test2", new BigDecimal("10"), "country"));
        cart.addProduct(new Product("test3", new BigDecimal("10"), "country"));
        cart.addProduct(new Product("test4", new BigDecimal("10"), "country"));
        cart.addProduct(new Product("test5", new BigDecimal("10"), "country"));
        cart.addProduct(new Product("test6", new BigDecimal("10"), "country"));

        cart.getLastFiveProducts().forEach(System.out::println);

        StringBuilder sb = new StringBuilder();
        sb.append(new Product("test2", new BigDecimal("10"), "country")).append(System.lineSeparator())
                .append(new Product("test3", new BigDecimal("10"), "country")).append(System.lineSeparator())
                .append(new Product("test4", new BigDecimal("10"), "country")).append(System.lineSeparator())
                .append(new Product("test5", new BigDecimal("10"), "country")).append(System.lineSeparator())
                .append(new Product("test6", new BigDecimal("10"), "country")).append(System.lineSeparator());

        Assert.assertEquals(sb.toString(), data.toString());
    }
}