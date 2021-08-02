package com.epam.batrachenko.task4.commands;

import com.epam.batrachenko.task4.services.CartService;
import com.epam.batrachenko.task4.services.StoreService;

public class PrintShoppingCart extends Command {
    @Override
    public boolean execute(StoreService store, CartService cart) {
        cart.getShoppingCartProducts().forEach((k, v) -> {
            System.out.println(k);
            System.out.print("Count of product:");
            System.out.println(v + System.lineSeparator());
        });
        return true;
    }

    @Override
    public String toString() {
        return "Print Shopping Cart";
    }
}
