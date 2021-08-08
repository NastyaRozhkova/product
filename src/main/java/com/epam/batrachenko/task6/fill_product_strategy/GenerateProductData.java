package com.epam.batrachenko.task6.fill_product_strategy;

import com.epam.batrachenko.task1.Entity.Accessories;
import com.epam.batrachenko.task1.Entity.ComputerPart;
import com.epam.batrachenko.task1.Entity.GraphicsCard;
import com.epam.batrachenko.task1.Entity.Product;
import com.epam.batrachenko.task3.List.UniqueProductArrayList;
import com.epam.batrachenko.task6.enums.Country;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.function.Supplier;

public class GenerateProductData implements FillProductDataStrategy {
    private Map<Integer, Supplier<Product>> generate = new HashMap<>();

    public GenerateProductData() {
        Random random = new Random();
        this.generate.put(1, () -> new Product("product " + random.nextInt(100000000),
                new BigDecimal(random.nextInt(1000000)),
                Country.values()[random.nextInt(19)].name()));

        this.generate.put(2, () -> new Accessories("product " + random.nextInt(100000000),
                new BigDecimal(random.nextInt(1000000)), Country.values()[random.nextInt(19)].name(),
                "type" + random.nextInt(100), "brand" + random.nextInt(100)));

        this.generate.put(3, () -> new ComputerPart("product " + random.nextInt(100000000),
                new BigDecimal(random.nextInt(1000000)), Country.values()[random.nextInt(19)].name(),
                "category" + random.nextInt(100), "purpose" + random.nextInt(100)));

        this.generate.put(4, () -> new GraphicsCard("product " + random.nextInt(100000000),
                new BigDecimal(random.nextInt(1000000)), Country.values()[random.nextInt(19)].name(),
                "category" + random.nextInt(100),
                "purpose" + random.nextInt(100),
                random.nextInt(32), "memoryType" + random.nextInt(100),
                "connector" + random.nextInt(100)));
    }

    public UniqueProductArrayList<Product> fill(int size) {
        UniqueProductArrayList<Product> products = new UniqueProductArrayList<>();
        Random random = new Random();
        for (int i = 0; i < size; ++i) {
            products.add(this.generate.get(random.nextInt(4) + 1).get());
        }
        return products;
    }
}