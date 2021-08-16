package com.epam.batrachenko.task7;

import com.epam.batrachenko.task1.Entity.Product;
import com.epam.batrachenko.task7.reflection.InputProductDataFromConsole;
import com.epam.batrachenko.task7.reflection.Resource;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Scanner;

public class InputAppWithReflection {
    public static void runApp() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Resource resource = new InputAppWithReflection().chooseLanguage();
        System.out.println("Input count of products");
        List<Product> products = new InputProductDataFromConsole().fill(new Scanner(System.in).nextInt(),resource);
        for (Product temp : products
        ) {
            System.out.println(temp);
        }
    }

    public Resource chooseLanguage() {
        System.out.println("Input language(en/ru)");
        return new Resource(new Scanner(System.in).nextLine());
    }
}
