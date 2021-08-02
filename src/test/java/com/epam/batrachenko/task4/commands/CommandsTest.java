package com.epam.batrachenko.task4.commands;

import com.epam.batrachenko.task1.Entity.Product;
import com.epam.batrachenko.task4.repository.ConsoleStore;
import com.epam.batrachenko.task4.repository.ShoppingCart;
import com.epam.batrachenko.task4.services.CartService;
import com.epam.batrachenko.task4.services.StoreService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.ArrayList;

public class CommandsTest {
    private PrintStream systemOut;
    private final ByteArrayOutputStream data = new ByteArrayOutputStream();
    private StoreService store;

    @Before
    public void setUpStream() {
        systemOut = System.out;
        System.setOut(new PrintStream(data));
    }

    @After
    public void revertStream() {
        System.setOut(systemOut);
    }

    @Before
    public void createAndFillStore() {
        ConsoleStore cs = new ConsoleStore();

        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product("prod1", new BigDecimal("1000"), "Ukraine"));
        products.add(new Product("prod2", new BigDecimal("2000"), "USA"));

        cs.addProducts(products);
        store = new StoreService(cs);
    }

    @Test
    public void shouldPrintShoppingCart() {
        Command command = new PrintShoppingCart();
        ShoppingCart sc = new ShoppingCart();
        sc.addProduct(new Product("test", new BigDecimal("10"), "country"));
        sc.addProduct(new Product("test2", new BigDecimal("11"), "country"));

        command.execute(store, new CartService(sc, store.getStore()));

        StringBuilder sb = new StringBuilder();
        sb.append(new Product("test", new BigDecimal("10"), "country").toString())
                .append(System.lineSeparator())
                .append("Count of product:1" + System.lineSeparator())
                .append(System.lineSeparator())
                .append(new Product("test2", new BigDecimal("11"), "country").toString())
                .append(System.lineSeparator()).append("Count of product:1" + System.lineSeparator())
                .append(System.lineSeparator());

        Assert.assertEquals(sb.toString(), data.toString());
    }

    @Test
    public void shouldPrintStoreProducts() {
        Command command = new PrintStoreProducts();
        ShoppingCart sc = new ShoppingCart();

        command.execute(store, new CartService(sc, store.getStore()));

        StringBuilder expected = new StringBuilder();
        for (Product p : store.getProducts()) {
            expected.append(p.toString()).append(System.lineSeparator());
        }

        Assert.assertEquals(expected.toString(), data.toString());
    }
}