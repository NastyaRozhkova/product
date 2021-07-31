package com.epam.batrachenko.task4.Store;

import com.epam.batrachenko.task1.Entity.Product;

import java.math.BigDecimal;
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
public class ShoppingCart {

    private final Map<Product, Long> cart;

    public ShoppingCart(ShoppingCart sc) {
        this.cart = new LinkedHashMap<>(sc.cart);
    }

    public ShoppingCart() {
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

    public void printShoppingCart() {
        cart.forEach((k, v) -> {
            System.out.println(k);
            System.out.print("Count of product:");
            System.out.println(v + "\n");
        });
    }

    /**
     * Make order from this shopping cart and save it in Console Store.
     * Print in console total price of this order.
     * In the end clear cart.
     */
    public void makeOrder() {
        BigDecimal totalPrice = new BigDecimal("0");
        for (Map.Entry<Product, Long> temp : cart.entrySet()) {
            totalPrice = totalPrice.add(temp.getKey().getPrice().multiply(new BigDecimal(String.valueOf(temp.getValue()))));
        }
        ConsoleStore.getInstance().addOrder(this);
        System.out.println("Total price of order is:" + totalPrice);
        clearCart();
    }

    /**
     * Print in console last five products, which was added.
     * If products in cart less than five, print their all.
     */
    public void printLastFiveProducts() {
        cart.keySet().stream().skip(cart.size() > 5 ? cart.size() - 5 : 0).forEach(System.out::println);
    }

    public void clearCart() {
        this.cart.clear();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShoppingCart that = (ShoppingCart) o;
        return Objects.equals(cart, that.cart);
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "cart=" + cart +
                '}';
    }
}
