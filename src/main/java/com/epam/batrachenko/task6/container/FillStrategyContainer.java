package com.epam.batrachenko.task6.container;

import com.epam.batrachenko.task6.fill_product_strategy.FillProductDataStrategy;
import com.epam.batrachenko.task6.fill_product_strategy.random.GenerateProductDataStrategy;
import com.epam.batrachenko.task6.fill_product_strategy.user_input.InputProductDataFromConsoleStrategy;

import java.util.HashMap;
import java.util.Map;

/**
 * Contains map of FillProductDataStrategy.
 *
 * @see FillProductDataStrategy
 */
public class FillStrategyContainer {
    private Map<Integer, FillProductDataStrategy> strategies = new HashMap();

    public FillStrategyContainer() {
        this.strategies.put(0, new InputProductDataFromConsoleStrategy());
        this.strategies.put(1, new GenerateProductDataStrategy());
    }

    public FillProductDataStrategy getStrategies(int code) {
        return this.strategies.get(code);
    }
}