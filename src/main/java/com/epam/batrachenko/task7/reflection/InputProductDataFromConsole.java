package com.epam.batrachenko.task7.reflection;

import com.epam.batrachenko.task1.Entity.Product;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class InputProductDataFromConsole {
    private final InputOutputData inputOutputData;
    private final Resource resource;

    public InputProductDataFromConsole(Resource resource) {
        inputOutputData = new InputOutputData();
        this.resource = resource;
    }

    public InputProductDataFromConsole(InputOutputData inputOutputData, Resource resource) {
        this.inputOutputData = inputOutputData;
        this.resource = resource;
    }

    public List<Product> fill(int size) throws IllegalAccessException, InstantiationException,
            NoSuchMethodException, InvocationTargetException {
        List<Product> products = new ArrayList<>();
        for (int i = 0; i < size; ++i) {
            products.add(createProduct(getProductClass()));
        }
        return products;
    }

    private Product createProduct(Class<? extends Product> prod) throws InstantiationException,
            IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        ProductFieldReflection fieldReflection = new ProductFieldReflection();
        Field[] fields = fieldReflection.getFields(prod);
        Map<String, String> data = inputOutputData.inputProductDataFromConsole(fields, resource);
        return fieldReflection.fillProduct(prod, fields, data);
    }

    private Class<? extends Product> getProductClass() {
        ProductClassesContainer productContainer = new ProductClassesContainer();
        StringBuilder classes = new StringBuilder();
        productContainer.getClasses().forEach((k, v) -> classes.append(k).append('-').append(v.getSimpleName()).append('\n'));
        return productContainer.getClassByCode(inputOutputData.inputCodeOfProductClass(classes.toString()));
    }
}

