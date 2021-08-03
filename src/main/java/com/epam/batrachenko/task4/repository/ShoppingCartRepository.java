package com.epam.batrachenko.task4.repository;

import com.epam.batrachenko.task1.Entity.Product;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * Contain linked hashMap of products and their count in shopping cart.
 * Has methods for processing shopping cart,
 * such as add product, make order and clear or print shopping cart.
 *
 * @author Vladyslav Batrachenko
 * @see Product, Map
 */
public class ShoppingCartRepository {

    private Map<Product, Long> cart;

    public ShoppingCartRepository(ShoppingCartRepository sc) {
        this.cart = new LinkedHashMap<>(sc.cart);
    }

    public ShoppingCartRepository() {
        cart = new LinkedHashMap<>();
    }

    public Set<Product> getProducts() {
        return cart.keySet();
    }

    public void addProduct(Product p) {
        Long count = cart.get(p);
        if (count == null) {
            count = 0L;
        }
        cart.put(p, ++count);
    }

    public void clearCart() {
        this.cart.clear();
    }

    public Map<Product, Long> getCart() {
        return cart;
    }

    public void setCart(Map<Product, Long> cart) {
        this.cart = cart;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShoppingCartRepository that = (ShoppingCartRepository) o;
        return Objects.equals(cart, that.cart);
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "cart=" + cart +
                '}';
    }
}
