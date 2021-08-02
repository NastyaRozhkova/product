package com.epam.batrachenko.task4.commands;

import com.epam.batrachenko.task4.services.CartService;
import com.epam.batrachenko.task4.services.StoreService;

public class PrintLastFiveProducts extends Command{
    @Override
    public boolean execute(StoreService store, CartService cart) {
        cart.getLastFiveProducts().forEach(System.out::println);
        return true;
    }

    @Override
    public String toString() {
        return "Print Last Five Products";
    }
}
