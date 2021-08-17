package com.epam.batrachenko.task7;

import com.epam.batrachenko.task1.Entity.Product;
import com.epam.batrachenko.task7.reflection.InputOutputData;
import com.epam.batrachenko.task7.reflection.InputProductDataFromConsole;
import com.epam.batrachenko.task7.reflection.Resource;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class InputAppWithReflection {
    public static void runApp() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        InputOutputData inputOutputData=new InputOutputData();
        Resource resource = chooseLanguage(inputOutputData);
        Integer count = Integer.parseInt(inputOutputData.getInput("Input count of products"));
        List<Product> products = new InputProductDataFromConsole(inputOutputData,resource).fill(count);
        for (Product temp : products
        ) {
            System.out.println(temp);
        }
    }

    public static Resource chooseLanguage(InputOutputData inputOutputData) {
        return new Resource(inputOutputData.getInput("Input language(en/ru)"));
    }
}
