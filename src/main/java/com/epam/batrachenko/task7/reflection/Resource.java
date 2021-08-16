package com.epam.batrachenko.task7.reflection;

import com.epam.batrachenko.task7.field_annotaions.FieldTittle;

import java.lang.reflect.Field;
import java.util.Locale;
import java.util.ResourceBundle;

public class Resource {
    private Locale locale;
    private ResourceBundle resourceBundle;
    private static final String INPUT = "input.";
    private static final String RESOURCES = "resources";

    public ResourceBundle getResourceBundle() {
        return resourceBundle;
    }

    public Resource(String localeName) {
        this.locale = new Locale(localeName);
        this.resourceBundle = ResourceBundle.getBundle(RESOURCES, locale);
    }

    public String getInputString(Field field) {
        return resourceBundle.getString(INPUT + field.getAnnotation(FieldTittle.class).tittle());
    }
}
