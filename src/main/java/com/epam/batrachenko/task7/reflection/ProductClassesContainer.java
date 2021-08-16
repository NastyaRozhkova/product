package com.epam.batrachenko.task7.reflection;

import com.epam.batrachenko.task1.Entity.Accessories;
import com.epam.batrachenko.task1.Entity.ComputerPart;
import com.epam.batrachenko.task1.Entity.GraphicsCard;
import com.epam.batrachenko.task1.Entity.Product;

import java.util.HashMap;
import java.util.Map;

public class ProductClassesContainer {
    private final Map<Integer, Class<? extends Product>> classes = new HashMap<>();

    public ProductClassesContainer() {
        classes.put(1, Product.class);
        classes.put(2, Accessories.class);
        classes.put(3, ComputerPart.class);
        classes.put(4, GraphicsCard.class);
    }

    public Class<? extends Product> getClassByCode(int code) {
        if (!classes.containsKey(code)) {
            return Product.class;
        }
        return classes.get(code);
    }

    public Map<Integer, Class<? extends Product>> getClasses() {
        return classes;
    }

}
