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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class StoreServiceTest {
    private StoreService store;

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
    public void shouldGetOrdersByPeriod() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        store.getOrdersByPeriod(dateFormat.parse("05-05-2020"), dateFormat.parse("05-05-2022"));

        StringBuilder expected = new StringBuilder();
        for (ShoppingCart p : store.getStore().getOrders().values()) {
            expected.append(p.toString()).append(System.lineSeparator());
        }

        Assert.assertEquals(expected.toString(), data.toString());
    }

    @Test
    public void shouldFindProductByName() {
        Assert.assertEquals(
                new Product("prod1", new BigDecimal("1000"), "Ukraine"),
                store.findProductByName("prod1").get());
    }

    @Test
    public void shouldNotFindProductByName() {
        Assert.assertFalse(store.findProductByName("prod42").isPresent());
    }

    @Test
    public void shouldGetFirstOrderSortedByDate() throws InterruptedException {
        CartService sc = new CartService(new ShoppingCart(), store.getStore());
        sc.addProduct(store.getProducts().get(0));

        Date date = new Date();
        sc.makeOrder();
        Thread.sleep(10000);
        sc.addProduct(store.getProducts().get(1));
        sc.makeOrder();
        sc.addProduct(store.getProducts().get(0));

        Assert.assertEquals(sc.getShoppingCart(), store.getFirstOrderSortedByDate(date).get().getValue());
    }
}