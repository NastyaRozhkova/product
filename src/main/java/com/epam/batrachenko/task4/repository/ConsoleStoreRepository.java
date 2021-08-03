package com.epam.batrachenko.task4.repository;

import com.epam.batrachenko.task1.Entity.Product;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TreeMap;


/**
 * Class, that implements functional of console store,
 * contain list of products and map of orders, where key is date of making order.
 *
 * @author Vladyslav Batrachenko
 * @see Product, ShoppingCart, TreeMap
 */
public class ConsoleStoreRepository {

    private List<Product> products;
    private TreeMap<Date, ShoppingCartRepository> orders;

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }

    public TreeMap<Date, ShoppingCartRepository> getOrders() {
        return orders;
    }

    public void addProducts(List<Product> products) {
        this.products.addAll(products);
    }

    public ConsoleStoreRepository() {
        this.orders = new TreeMap<>();
        this.products = new ArrayList<>();
    }

    public void addOrder(ShoppingCartRepository sc) {
        orders.put(new Date(), new ShoppingCartRepository(sc));
    }
}
