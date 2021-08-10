package com.epam.batrachenko.task6.fill_product_strategy.random;

import com.epam.batrachenko.task1.Entity.Accessories;
import com.epam.batrachenko.task1.Entity.ComputerPart;
import com.epam.batrachenko.task1.Entity.GraphicsCard;
import com.epam.batrachenko.task1.Entity.Product;
import com.epam.batrachenko.task3.List.UniqueProductArrayList;
import com.epam.batrachenko.task6.fill_product_strategy.FillProductDataStrategy;
import com.epam.batrachenko.task6.fill_product_strategy.random.country.Country;
import com.epam.batrachenko.task6.utils.Constants;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.function.Supplier;

/**
 * Generate product container of different randomize type of products.
 *
 * @author Vladyslav_Batrachenko
 */
public class GenerateProductDataStrategy implements FillProductDataStrategy {
    private Map<Integer, Supplier<Product>> generate = new HashMap<>();

    public GenerateProductDataStrategy() {
        this.generate.put(Constants.PRODUCT_CREATOR_NUMBER, createProduct());
        this.generate.put(Constants.ACCESSORIES_CREATOR_NUMBER, createAccessories());
        this.generate.put(Constants.COMPUTER_PART_CREATOR_DATA_NUMBER, createComputerPart());
        this.generate.put(Constants.GRAPHICS_CARD_CREATOR_NUMBER, createGraphicsCard());
    }

    public UniqueProductArrayList<Product> fill(int size) {
        UniqueProductArrayList<Product> products = new UniqueProductArrayList<>();
        Random random = new Random();
        for (int i = 0; i < size; ++i) {
            products.add(this.generate.get(random.nextInt(4) + 1).get());
        }
        return products;
    }

    private Supplier<Product> createProduct() {
        Random random = new Random();
        return () -> new Product(Constants.PRODUCT + random.nextInt(Constants.RANDOM_BOUND),
                new BigDecimal(random.nextInt(Constants.RANDOM_BOUND)),
                Country.values()[random.nextInt(Constants.COUNTRY_COUNT)].name());
    }

    private Supplier<Product> createComputerPart() {
        Random random = new Random();
        return () -> new ComputerPart(Constants.PRODUCT + random.nextInt(Constants.RANDOM_BOUND),
                new BigDecimal(random.nextInt(Constants.RANDOM_BOUND)),
                Country.values()[random.nextInt(Constants.COUNTRY_COUNT)].name(),
                Constants.PRODUCT_FIELD_CATEGORY + random.nextInt(Constants.RANDOM_BOUND),
                Constants.PRODUCT_FIELD_PURPOSE + random.nextInt(Constants.RANDOM_BOUND));
    }

    private Supplier<Product> createAccessories() {
        Random random = new Random();
        return () -> new Accessories(Constants.PRODUCT + random.nextInt(Constants.RANDOM_BOUND),
                new BigDecimal(random.nextInt(Constants.RANDOM_BOUND)),
                Country.values()[random.nextInt(Constants.COUNTRY_COUNT)].name(),
                Constants.PRODUCT_FIELD_TYPE + random.nextInt(Constants.RANDOM_BOUND),
                Constants.PRODUCT_FIELD_BRAND + random.nextInt(Constants.RANDOM_BOUND));
    }

    private Supplier<Product> createGraphicsCard() {
        Random random = new Random();
        return () -> new GraphicsCard(Constants.PRODUCT + random.nextInt(Constants.RANDOM_BOUND),
                new BigDecimal(random.nextInt(Constants.RANDOM_BOUND)),
                Country.values()[random.nextInt(Constants.COUNTRY_COUNT)].name(),
                Constants.PRODUCT_FIELD_CATEGORY + random.nextInt(Constants.RANDOM_BOUND),
                Constants.PRODUCT_FIELD_PURPOSE + random.nextInt(Constants.RANDOM_BOUND),
                random.nextInt(32),
                Constants.INPUT_MEMORY_TYPE + random.nextInt(Constants.RANDOM_BOUND),
                Constants.INPUT_CONNECTOR + random.nextInt(Constants.RANDOM_BOUND));
    }
}