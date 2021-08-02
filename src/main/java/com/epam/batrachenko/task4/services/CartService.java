package com.epam.batrachenko.task4.services;

import com.epam.batrachenko.task1.Entity.Product;
import com.epam.batrachenko.task4.repository.ConsoleStore;
import com.epam.batrachenko.task4.repository.ShoppingCart;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CartService {
    private final ShoppingCart sc;
    private final ConsoleStore store;

    public CartService(ShoppingCart sc, ConsoleStore store) {
        this.sc = sc;
        this.store = store;
    }

    /**
     * Print in console last five products, which was added.
     * If products in cart less than five, print their all.
     *
     * @return
     */
    public List<Product> getLastFiveProducts() {
        return sc.getCart().keySet()
                .stream()
                .skip(sc.getCart().size() > 5 ? sc.getCart().size() - 5 : 0)
                .collect(Collectors.toList());
    }

    /**
     * Make order from this shopping cart and save it in Console Store.
     * Print in console total price of this order.
     * In the end clear cart.
     */
    public BigDecimal makeOrder() {
        BigDecimal totalPrice = new BigDecimal("0");
        for (Map.Entry<Product, Long> temp : sc.getCart().entrySet()) {
            totalPrice = totalPrice.add(temp.getKey().getPrice().multiply(new BigDecimal(String.valueOf(temp.getValue()))));
        }
        store.addOrder(sc);
        sc.clearCart();
        return totalPrice;
    }

    public Map<Product, Long> getShoppingCartProducts() {
        return sc.getCart();
    }

    public void addProduct(Product p) {
        if (p != null) {
            sc.addProduct(p);
        }
    }

    public ShoppingCart getShoppingCart() {
        return sc;
    }
}
