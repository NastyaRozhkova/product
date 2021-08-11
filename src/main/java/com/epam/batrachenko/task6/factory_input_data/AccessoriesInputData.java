package com.epam.batrachenko.task6.factory_input_data;

import com.epam.batrachenko.task1.Entity.Accessories;
import com.epam.batrachenko.task1.Entity.Product;
import com.epam.batrachenko.task6.constants.Constants;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

import java.util.Scanner;

public class AccessoriesInputData extends ProductInputData {
    private static final Logger log = LoggerFactory.getLogger(AccessoriesInputData.class);

    @Override
    public Product inputDataFromConsole() {
        Scanner sc = new Scanner(System.in);
        Product p = super.inputDataFromConsole();
        log.trace(Constants.INPUT_TYPE);
        String type = sc.nextLine();
        log.trace(Constants.INPUT_BRAND);
        String brand = sc.nextLine();
        return new Accessories(p.getName(), p.getPrice(), p.getCountry(), type, brand);
    }

    @Override
    public String toString() {
        return Constants.ACCESSORIES;
    }
}
