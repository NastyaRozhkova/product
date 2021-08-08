package com.epam.batrachenko.task6.container;

import com.epam.batrachenko.task6.fill_product_strategy.*;

import java.util.HashMap;
import java.util.Map;

public class FillStrategyContainer {
    private Map<Integer, FillProductDataStrategy> strategies = new HashMap();

    public FillStrategyContainer() {
        this.strategies.put(0, new InputProductDataFromConsole());
        this.strategies.put(1, new GenerateProductData());
    }

    public FillProductDataStrategy getStrategies(int code) {
        return this.strategies.get(code);
    }
}