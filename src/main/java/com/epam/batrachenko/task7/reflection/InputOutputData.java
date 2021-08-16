package com.epam.batrachenko.task7.reflection;

import com.epam.batrachenko.task7.field_annotaions.FieldTittle;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class InputOutputData {
    private final Scanner sc;

    public InputOutputData() {
        sc = new Scanner(System.in);
    }

    public InputOutputData(InputStream input) {
        this.sc = new Scanner(input);
    }

    public Integer inputCodeOfProductClass() {
        System.out.println("Input code");
        new ProductClassesContainer().getClasses().forEach((k, v) -> System.out.println(k + "-" + v.getSimpleName()));
        return Integer.parseInt(inputString());
    }

    public void printField(Field field, Resource resource) {
        System.out.println(resource.getInputString(field));
    }

    public String inputString() {
        return sc.nextLine();
    }

    public Map<String, String> inputProductDataFromConsole(Field[] fields, Resource resource) {
        Map<String, String> fieldsData = new HashMap<>();
        for (Field field : fields) {
            if (field.isAnnotationPresent(FieldTittle.class)) {
                printField(field, resource);
                fieldsData.put(field.getName(), inputString());
            }
        }
        return fieldsData;
    }
}
