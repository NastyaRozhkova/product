package com.epam.batrachenko.task6.fill_product_strategy;

import com.epam.batrachenko.task1.Entity.Product;
import com.epam.batrachenko.task3.List.UniqueProductArrayList;
import com.epam.batrachenko.task6.input_strategy.*;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class InputProductDataFromConsole implements FillProductDataStrategy {
    private static final Map<Integer, ProductInputData> strategies = new HashMap<>();
    private static final Logger log = LoggerFactory.getLogger(InputProductDataFromConsole.class);

    public UniqueProductArrayList<Product> fill(int size) {
        UniqueProductArrayList<Product> products = new UniqueProductArrayList<>();

        for(int i = 0; i < size; ++i) {
            ProductInputData strategy = this.getInputStrategy();
            products.add(strategy.inputDataFromConsole());
        }

        return products;
    }

    private ProductInputData getInputStrategy() {
        log.trace("Input type of product");
        strategies.forEach((k, v) -> log.trace(k + " - " + v));
        int code = (new Scanner(System.in)).nextInt();
        return !strategies.containsKey(code) ? new ProductInputData() : strategies.get(code);
    }

    static {
        strategies.put(1, new ProductInputData());
        strategies.put(2, new ComputerPartInputData());
        strategies.put(3, new AccessoriesInputData());
        strategies.put(4, new GraphicsCardInputData());
    }
}

