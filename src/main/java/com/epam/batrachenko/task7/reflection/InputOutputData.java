package com.epam.batrachenko.task7.reflection;

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

    public Integer inputCodeOfProductClass(String classes) {
        System.out.println("Input code");
        System.out.println(classes);
        return Integer.parseInt(inputString());
    }

    public String getInput(String text) {
        System.out.println(text);
        return inputString();
    }

    public void printField(String field, Resource resource) {
        System.out.println(resource.getInputString(field));
    }

    public String inputString() {
        return sc.nextLine();
    }

    public Map<String, String> inputProductDataFromConsole(String[] fields, Resource resource) {
        Map<String, String> fieldsData = new HashMap<>();
        for (String field : fields) {
            printField(field, resource);
            fieldsData.put(field, inputString());
        }
        return fieldsData;
    }
}
