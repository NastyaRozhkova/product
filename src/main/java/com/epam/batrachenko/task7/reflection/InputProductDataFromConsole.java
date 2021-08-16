package com.epam.batrachenko.task7.reflection;

import com.epam.batrachenko.task1.Entity.Product;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class InputProductDataFromConsole {
    private InputOutputData inputOutputData = new InputOutputData();

    public List<Product> fill(int size, Resource resource) throws IllegalAccessException, InstantiationException,
            NoSuchMethodException, InvocationTargetException {
        List<Product> products = new ArrayList<>();
        for (int i = 0; i < size; ++i) {
            products.add(createProduct(getProductClass(), resource));
        }
        return products;
    }

    private Product createProduct(Class<? extends Product> prod, Resource resource) throws InstantiationException,
            IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        ProductFieldReflection fieldReflection = new ProductFieldReflection();
        Field[] fields = fieldReflection.getFields(prod);
        Map<String, String> data = inputOutputData.inputProductDataFromConsole(fields, resource);
        return fieldReflection.fillProduct(prod, fields, data);
    }

    private Class<? extends Product> getProductClass() {
        return new ProductClassesContainer().getClassByCode(inputOutputData.inputCodeOfProductClass());
    }
}

