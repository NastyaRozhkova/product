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
public class ConsoleStore {

    private List<Product> products;
    private TreeMap<Date, ShoppingCart> orders;

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void setOrders(TreeMap<Date, ShoppingCart> orders) {
        this.orders = orders;
    }

    public List<Product> getProducts() {
        return products;
    }

    public TreeMap<Date, ShoppingCart> getOrders() {
        return orders;
    }

    public void addProducts(List<Product> products) {
        this.products.addAll(products);
    }

    public ConsoleStore() {
        this.orders = new TreeMap<>();
        this.products = new ArrayList<>();
    }

    public void addOrder(ShoppingCart sc) {
        orders.put(new Date(), new ShoppingCart(sc));
    }
}
