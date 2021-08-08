package com.epam.batrachenko.task6.fill_product_strategy;

import com.epam.batrachenko.task1.Entity.Product;
import com.epam.batrachenko.task3.List.UniqueProductArrayList;

public interface FillProductDataStrategy {
    UniqueProductArrayList<Product> fill(int var1);
}
