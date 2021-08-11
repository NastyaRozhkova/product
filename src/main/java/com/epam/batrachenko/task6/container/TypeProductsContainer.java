package com.epam.batrachenko.task6.container;

import com.epam.batrachenko.task6.factory.AccessoriesCreator;
import com.epam.batrachenko.task6.factory.ComputerPartCreator;
import com.epam.batrachenko.task6.factory.GraphicsCardCreator;
import com.epam.batrachenko.task6.factory.ProductCreator;
import com.epam.batrachenko.task6.constants.Constants;

import java.util.HashMap;
import java.util.Map;

/**
 * Contains map of ProductCreator.
 *
 * @see ProductCreator
 */
public class TypeProductsContainer {
    private Map<String, ProductCreator> typeProducts = new HashMap();

    public TypeProductsContainer() {
        this.typeProducts.put(Constants.PRODUCT, new ProductCreator());
        this.typeProducts.put(Constants.ACCESSORIES, new AccessoriesCreator());
        this.typeProducts.put(Constants.COMPUTER_PART, new ComputerPartCreator());
        this.typeProducts.put(Constants.GRAPHICS_CARD, new GraphicsCardCreator());
    }

    public ProductCreator getTypeProducts(String line) {
        return this.typeProducts.get(line.split("\\{")[0]);
    }
}

