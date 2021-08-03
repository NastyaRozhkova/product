package com.epam.batrachenko.task4;

import com.epam.batrachenko.task1.Entity.Accessories;
import com.epam.batrachenko.task1.Entity.ComputerPart;
import com.epam.batrachenko.task1.Entity.GraphicsCard;
import com.epam.batrachenko.task1.Entity.Product;
import com.epam.batrachenko.task4.commands.CommandContainer;
import com.epam.batrachenko.task4.repository.ConsoleStoreRepository;
import com.epam.batrachenko.task4.repository.ShoppingCartRepository;
import com.epam.batrachenko.task4.services.CartService;
import com.epam.batrachenko.task4.services.StoreService;
import com.epam.batrachenko.task4.util.Constants;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private final static StoreService store;
    private final static CartService sc;

    static {
        ConsoleStoreRepository st = new ConsoleStoreRepository();
        fillStore(st);
        store = new StoreService(st);
        sc = new CartService(new ShoppingCartRepository(), st);
    }

    public static void main(String... args) {
        int code = -1;
        Scanner scanner = new Scanner(System.in);
        while (code != 0) {
            printMenu();
            code = scanner.nextInt();
            CommandContainer.get(code).execute(store, sc);
        }
    }

    public static void fillStore(ConsoleStoreRepository store) {
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product("AsusNt32", new BigDecimal("1000"), "Ukraine"));
        products.add(new Accessories("logitech g102", new BigDecimal("2000"), "USA", "game mouse", "logitech"));
        products.add(new ComputerPart("Kingston SSD HyperX Fury 3D 480GB 2.5", new BigDecimal("500"), "Ukraine", "ssd disk", ""));
        products.add(new GraphicsCard("Gigabyte PCI-Ex GeForce RTX 3070 Ti", new BigDecimal("800"), "Germany", "GraphicCard", "Gaming", 8, "Gb", "GDDR6X"));
        products.add(new Product("Lenovo ideapad115", new BigDecimal("1500"), "France"));

        store.addProducts(products);
    }

    public static void printMenu() {
        System.out.println(Constants.INPUT_CODE);
        CommandContainer.getCommands().forEach((k, v) -> {
            System.out.println(k + " - " + v);
        });
    }

}
