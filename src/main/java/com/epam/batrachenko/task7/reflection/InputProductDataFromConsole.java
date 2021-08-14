package com.epam.batrachenko.task7.reflection;

import com.epam.batrachenko.task1.Entity.Product;
import com.epam.batrachenko.task7.field_annotaions.FieldTittle;
import com.epam.batrachenko.task7.util.Resource;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class InputProductDataFromConsole {
    private Scanner sc = new Scanner(System.in);

    public List<Product> fill(int size) throws IllegalAccessException, InstantiationException,
            NoSuchMethodException, InvocationTargetException {
        List<Product> products = new ArrayList<>();
        for (int i = 0; i < size; ++i) {
            products.add(inputDataFromConsole(getProductClass()));
        }
        return products;
    }

    private Product inputDataFromConsole(Class<? extends Product> prod) throws InstantiationException,
            IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Field[] fields = getFields(prod);
        ResourceBundle rb = Resource.getResourceBundle();
        Product product = prod.newInstance();

        for (Field field : fields) {
            if (field.isAnnotationPresent(FieldTittle.class)) {
                System.out.println(
                        rb.getString("input." + field.getAnnotation(FieldTittle.class).tittle()));
                field.setAccessible(true);
                Constructor constructorField = field.getType().getDeclaredConstructor(String.class);
                field.set(product, constructorField.newInstance(sc.nextLine()));
            }
        }
        return product;
    }

    private Class<? extends Product> getProductClass() {
        System.out.println("Input code");
        ProductClassesContainer.getClasses().forEach((k, v) -> System.out.println(k + "-" + v.getSimpleName()));
        return ProductClassesContainer.getClassByCode(sc.nextInt());
    }

    private Field[] getFields(Class<?> prod) {
        List<Field> fields = new ArrayList<>();
        while (prod.getSuperclass() != null) {
            fields.addAll(0, Arrays.asList(prod.getDeclaredFields()));
            prod = prod.getSuperclass();
        }
        return fields.toArray(new Field[0]);
    }
}

