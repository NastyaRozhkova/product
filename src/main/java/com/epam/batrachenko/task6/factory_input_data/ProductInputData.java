package com.epam.batrachenko.task6.factory_input_data;

import com.epam.batrachenko.task1.Entity.Product;
import com.epam.batrachenko.task6.utils.Constants;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Input data from console to create product.
 * Use pattern "factory".
 *
 * @author Vladyslav_Batrachenko
 */
public class ProductInputData {
    private static final Logger log = LoggerFactory.getLogger(ProductInputData.class);

    public Product inputDataFromConsole() {
        Scanner sc = new Scanner(System.in);
        log.trace(Constants.INPUT_NAME);
        String name = sc.nextLine();
        log.trace(Constants.INPUT_PRICE);
        String price = sc.nextLine();
        log.trace(Constants.INPUT_COUNTRY);
        String country = sc.nextLine();
        return new Product(name, new BigDecimal(price), country);
    }

    @Override
    public String toString() {
        return Constants.PRODUCT;
    }
}
