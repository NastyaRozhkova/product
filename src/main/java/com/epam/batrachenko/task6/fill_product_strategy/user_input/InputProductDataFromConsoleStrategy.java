package com.epam.batrachenko.task6.fill_product_strategy.user_input;

import com.epam.batrachenko.task1.Entity.Product;
import com.epam.batrachenko.task3.List.UniqueProductArrayList;
import com.epam.batrachenko.task6.container.ProductInputDataContainer;
import com.epam.batrachenko.task6.factory_input_data.ProductInputData;
import com.epam.batrachenko.task6.fill_product_strategy.FillProductDataStrategy;
import com.epam.batrachenko.task6.utils.Constants;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

import java.util.Scanner;

/**
 * Get type of input product from console
 * and use appropriate class to fill product container.
 *
 * @see UniqueProductArrayList,ProductInputData
 * @author Vladyslav_Batrachenko
 */
public class InputProductDataFromConsoleStrategy implements FillProductDataStrategy {
    private static final Logger log = LoggerFactory.getLogger(InputProductDataFromConsoleStrategy.class);

    public UniqueProductArrayList<Product> fill(int size) {
        UniqueProductArrayList<Product> products = new UniqueProductArrayList<>();

        for (int i = 0; i < size; ++i) {
            ProductInputData strategy = this.getInputStrategy();
            products.add(strategy.inputDataFromConsole());
        }
        return products;
    }

    private ProductInputData getInputStrategy() {
        log.trace(Constants.INPUT_TYPE_PRODUCT);
        ProductInputDataContainer container = new ProductInputDataContainer();
        container.getInputDataMap().forEach((k, v) -> log.trace(k + " - " + v));
        int code = (new Scanner(System.in)).nextInt();
        return container.getInputData(code);
    }

}

