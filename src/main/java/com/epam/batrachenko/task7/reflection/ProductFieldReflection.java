package com.epam.batrachenko.task7.reflection;

import com.epam.batrachenko.task1.Entity.Product;
import com.epam.batrachenko.task7.field_annotaions.FieldTittle;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ProductFieldReflection {
    public Product fillProduct(Class<? extends Product> prod, Field[] fields, Map<String, String> data) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Product product = prod.newInstance();
        for (Field field : fields) {
            field.setAccessible(true);
            Constructor constructorField = field.getType().getDeclaredConstructor(String.class);
            field.set(product, constructorField.newInstance(data.get(field.getName())));
        }
        return product;
    }

    public Field[] getFields(Class<?> prod) {
        List<Field> fields = new ArrayList<>();
        while (prod.getSuperclass() != null) {
            List<Field> filteredFields = new ArrayList<>();
            for (Field field : prod.getDeclaredFields()) {
                if (field.isAnnotationPresent(FieldTittle.class)) {
                    filteredFields.add(field);
                }
            }
            fields.addAll(0, filteredFields);
            prod = prod.getSuperclass();
        }
        return fields.toArray(new Field[0]);
    }
}
