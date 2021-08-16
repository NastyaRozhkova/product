package com.epam.batrachenko.task7.reflection;

import com.epam.batrachenko.task7.field_annotaions.FieldTittle;

import java.lang.reflect.Field;
import java.util.Locale;
import java.util.ResourceBundle;

public class Resource {
    private Locale locale;
    private ResourceBundle resourceBundle;

    public ResourceBundle getResourceBundle() {
        return resourceBundle;
    }

    public Resource(String localeName) {
        this.locale = new Locale(localeName);
        this.resourceBundle = ResourceBundle.getBundle("resources", locale);
    }

    public String getInputString(Field field){
        return resourceBundle.getString("input." + field.getAnnotation(FieldTittle.class).tittle());
    }
}
