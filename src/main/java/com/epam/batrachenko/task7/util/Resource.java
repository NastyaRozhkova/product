package com.epam.batrachenko.task7.util;

import java.util.Locale;
import java.util.ResourceBundle;

public class Resource {
    private static Locale locale = new Locale("");
    private static ResourceBundle resourceBundle = ResourceBundle.getBundle("resources", locale);

    public static ResourceBundle getResourceBundle() {
        return resourceBundle;
    }

    private Resource() {
    }

    public static void setLocale(String localeName) {
        Resource.locale = new Locale(localeName);
        Resource.resourceBundle = ResourceBundle.getBundle("resources", locale);
    }
}
