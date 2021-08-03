package com.epam.batrachenko.task4.services;

import com.epam.batrachenko.task1.Entity.Product;
import com.epam.batrachenko.task4.repository.ConsoleStoreRepository;
import com.epam.batrachenko.task4.repository.ShoppingCartRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Contain methods for processing shopping cart.
 *
 * @author Vladyslav Batrachenko
 * @see ShoppingCartRepository,ConsoleStoreRepository
 */
public class CartService {
    private final ShoppingCartRepository sc;
    private final ConsoleStoreRepository store;

    public CartService(ShoppingCartRepository sc, ConsoleStoreRepository store) {
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
        BigDecimal totalPrice = getTotalPrice();
        store.addOrder(sc);
        sc.clearCart();
        return totalPrice;
    }

    public BigDecimal getTotalPrice() {
        BigDecimal totalPrice = new BigDecimal("0");
        for (Map.Entry<Product, Long> temp : sc.getCart().entrySet()) {
            BigDecimal priceProducts = temp.getKey().getPrice().multiply(
                    new BigDecimal(temp.getValue().toString()));
            totalPrice = totalPrice.add(priceProducts);
        }
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

    public ShoppingCartRepository getShoppingCart() {
        return sc;
    }
}
