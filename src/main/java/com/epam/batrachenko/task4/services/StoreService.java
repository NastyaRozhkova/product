package com.epam.batrachenko.task4.services;

import com.epam.batrachenko.task1.Entity.Product;
import com.epam.batrachenko.task4.repository.ConsoleStoreRepository;
import com.epam.batrachenko.task4.repository.ShoppingCartRepository;
import com.epam.batrachenko.task4.util.DateUtil;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Contain methods for processing console store.
 *
 * @author Vladyslav Batrachenko
 * @see ConsoleStoreRepository
 */
public class StoreService {
    private final ConsoleStoreRepository store;

    public StoreService(ConsoleStoreRepository store) {
        this.store = store;
    }

    /**
     * Print in console all Shopping carts, which contains in orders,
     * that was made in adjusted period (start and end passed as parameters)
     */
    public List<ShoppingCartRepository> getOrdersByPeriod(Date start, Date end) {
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
    public Optional<Map.Entry<Date, ShoppingCartRepository>> getFirstOrderSortedByDate(Date start) {
        return store.getOrders().entrySet()
                .stream()
                .min((d1, d2) -> DateUtil.compareTwoDateByThird(d1.getKey(), d2.getKey(), start));
    }

    public ConsoleStoreRepository getStore() {
        return store;
    }
}
