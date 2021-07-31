package com.epam.batrachenko.task4.Store;

import com.epam.batrachenko.task1.Entity.Product;

import java.util.*;

/**
 * Implement pattern "Singleton".
 * Class, that implements functional of console store,
 * contain list of products and map of orders, where key is date of making order.
 *
 * @author Vladyslav Batrachenko
 * @see Product, ShoppingCart, TreeMap
 */
public class ConsoleStore {
    private static ConsoleStore instance;

    public static ConsoleStore getInstance() {
        if (instance == null) {
            instance = new ConsoleStore();
        }
        return instance;
    }

    private final List<Product> products;
    private final TreeMap<Date, ShoppingCart> orders;

    public List<Product> getProducts() {
        return products;
    }

    public TreeMap<Date, ShoppingCart> getOrders() {
        return orders;
    }

    public void addProducts(List<Product> products) {
        this.products.addAll(products);
    }

    private ConsoleStore() {
        this.orders = new TreeMap<>();
        this.products = new ArrayList<>();
    }

    public void printProducts() {
        products.forEach(System.out::println);
    }

    public void addOrder(ShoppingCart sc) {
        orders.put(new Date(), new ShoppingCart(sc));
    }

    /**
     * Print in console all Shopping carts, which contains in orders,
     * that was made in adjusted period (start and end passed as parameters)
     **/
    public void printOrders(Date start, Date end) {
        orders.entrySet().stream()
                .filter((entry) -> entry.getKey().after(start) && entry.getKey().before(end))
                .forEach((entry) -> System.out.println(entry.getValue()));
    }

    public Optional<Product> findProductByName(String name) {
        return products.stream().filter((product) -> product.getName().compareTo(name) == 0).findFirst();
    }

    /**
     * Find and return a first order in collection,
     * sorted by increasing the difference between the creation order date
     * and the given date, which is passed as an argument
     **/
    public Optional<Map.Entry<Date, ShoppingCart>> getFirstOrderSortedByDate(Date start) {
        return orders.entrySet().stream().min((d1, d2) ->
                (int) (Math.abs(d1.getKey().getTime() - start.getTime()) - Math.abs(d2.getKey().getTime() - start.getTime())));
    }

}
