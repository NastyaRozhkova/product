package com.epam.batrachenko.task4.commands;

import com.epam.batrachenko.task4.services.CartService;
import com.epam.batrachenko.task4.services.StoreService;

import static com.epam.batrachenko.task4.util.Constants.EXIT;

public class ExitCommand extends Command {
    @Override
    public boolean execute(StoreService store, CartService cart) {
        System.out.println(EXIT);
        return true;
    }

    @Override
    public String toString() {
        return EXIT;
    }
}
