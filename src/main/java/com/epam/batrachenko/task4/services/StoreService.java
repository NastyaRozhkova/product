package com.epam.batrachenko.task4.services;

import com.epam.batrachenko.task1.Entity.Product;
import com.epam.batrachenko.task4.repository.ConsoleStore;
import com.epam.batrachenko.task4.repository.ShoppingCart;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class StoreService {
    private final ConsoleStore store;

    public StoreService(ConsoleStore store) {
        this.store = store;
    }

    /**
     * Print in console all Shopping carts, which contains in orders,
     * that was made in adjusted period (start and end passed as parameters)
     */
    public List<ShoppingCart> getOrdersByPeriod(Date start, Date end) {
        return store.getOrders().entrySet().stream()
                .filter(entry -> entry.getKey().after(start) && entry.getKey().before(end))
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    public List<Product> getProducts() {
        return store.getProducts();
    }

    public Optional<Product> findProductByName(String name) {
        return store.getProducts().stream()
                .filter((product) -> product.getName().equals(name))
                .findFirst();
    }

    /**
     * Find and return a first order in collection,
     * sorted by increasing the difference between the creation order date
     * and the given date, which is passed as an argument
     **/
    public Optional<Map.Entry<Date, ShoppingCart>> getFirstOrderSortedByDate(Date start) {
        return store.getOrders().entrySet()
                .stream()
                .min((d1, d2) ->
                        (int) (Math.abs(d1.getKey().getTime() - start.getTime()) - Math.abs(d2.getKey().getTime() - start.getTime())));
    }

    public ConsoleStore getStore() {
        return store;
    }
}
