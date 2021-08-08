package com.epam.batrachenko.task6;

import com.epam.batrachenko.task1.Entity.Product;
import com.epam.batrachenko.task3.List.UniqueProductArrayList;
import com.epam.batrachenko.task6.container.FillStrategyContainer;
import com.epam.batrachenko.task6.fill_product_strategy.FillProductDataStrategy;
import com.epam.batrachenko.task6.utils.ProductContainerUtil;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

import java.util.Scanner;

public class AddingProductsToCatalog {
    private static final Logger log = LoggerFactory.getLogger(AddingProductsToCatalog.class);

    public AddingProductsToCatalog() {
    }

    public static void addProducts() throws Exception {
        UniqueProductArrayList<Product> products = new UniqueProductArrayList();
        products.addAll(ProductContainerUtil.load("C:\\Users\\Vl\\pre_prod_java_q3_2021\\save.txt"));

        log.trace("Choose type of input of date: console input or generate data (0/1)");
        FillProductDataStrategy strategy = (new FillStrategyContainer()).getStrategies((new Scanner(System.in)).nextInt());

        log.trace("Input count of products");
        products.addAll(strategy.fill((new Scanner(System.in)).nextInt()));

        ProductContainerUtil.save(products, "C:\\Users\\Vl\\pre_prod_java_q3_2021\\save.txt");
    }
}

