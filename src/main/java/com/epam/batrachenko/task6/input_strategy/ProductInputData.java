package com.epam.batrachenko.task6.input_strategy;

import com.epam.batrachenko.task1.Entity.Product;
import com.epam.batrachenko.task6.utils.InputConstants;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

import java.math.BigDecimal;
import java.util.Scanner;

public class ProductInputData {
    private static final Logger log = LoggerFactory.getLogger(ProductInputData.class);

    public Product inputDataFromConsole() {
        Scanner sc = new Scanner(System.in);
        log.trace(InputConstants.INPUT_NAME);
        String name = sc.nextLine();
        log.trace(InputConstants.INPUT_PRICE);
        String price = sc.nextLine();
        log.trace(InputConstants.INPUT_COUNTRY);
        String country = sc.nextLine();
        return new Product(name, new BigDecimal(price), country);
    }

    @Override
    public String toString() {
        return "Product";
    }
}
