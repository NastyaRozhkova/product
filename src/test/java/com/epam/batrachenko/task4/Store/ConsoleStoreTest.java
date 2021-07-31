package com.epam.batrachenko.task4.Store;

import com.epam.batrachenko.task1.Entity.Product;
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
import java.util.TreeMap;

public class ConsoleStoreTest {
    private ConsoleStore store;

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
    public void createStore() {
        store = ConsoleStore.getInstance();

        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product("prod1", new BigDecimal("1000"), "Ukraine"));
        products.add(new Product("prod2", new BigDecimal("2000"), "USA"));

        store.addProducts(products);
    }

    @Test
    public void shouldAddProducts() {
        ArrayList<Product> expectedProducts = new ArrayList<>(store.getProducts());

        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product("prod3", new BigDecimal("500"), "Ukraine"));
        expectedProducts.addAll(products);
        store.addProducts(products);

        Assert.assertArrayEquals(expectedProducts.toArray(), store.getProducts().toArray());
    }

    @Test
    public void shouldPrintProducts() {
        store.printProducts();

        StringBuilder expected = new StringBuilder();
        for (Product p : store.getProducts()) {
            expected.append(p.toString()).append(System.lineSeparator());
        }

        Assert.assertEquals(expected.toString(), data.toString());
    }

    @Test
    public void shouldAddOrder() {
        TreeMap<Date, ShoppingCart> expected = new TreeMap<>(store.getOrders());
        ShoppingCart sc = new ShoppingCart();

        sc.addProduct(store.getProducts().get(0));
        store.addOrder(sc);
        expected.put(new Date(), new ShoppingCart(sc));

        Assert.assertArrayEquals(expected.values().toArray(), store.getOrders().values().toArray());
    }

    @Test
    public void shouldPrintOrders() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        store.printOrders(dateFormat.parse("05-05-2020"), dateFormat.parse("05-05-2022"));

        StringBuilder expected = new StringBuilder();
        for (ShoppingCart p : store.getOrders().values()) {
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
        ShoppingCart sc = new ShoppingCart();
        sc.addProduct(store.getProducts().get(0));

        Date date = new Date();
        sc.makeOrder();
        Thread.sleep(10000);
        sc.addProduct(store.getProducts().get(1));
        sc.makeOrder();
        sc.addProduct(store.getProducts().get(0));

        Assert.assertEquals(sc, store.getFirstOrderSortedByDate(date).get().getValue());
    }
}