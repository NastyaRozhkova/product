package com.epam.batrachenko.task4.commands;

import com.epam.batrachenko.task4.services.CartService;
import com.epam.batrachenko.task4.services.StoreService;

public class ErrorCommand extends Command {
    @Override
    public boolean execute(StoreService store, CartService cart) {
        System.out.println("No such command");
        return true;
    }

    @Override
    public String toString() {
        return "Error Command";
    }
}
