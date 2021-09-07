package com.epam.batrachenko.task9.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    public static String parseFromRequest(String regex, int group, String request) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(request);
        if (matcher.find()) {
            return matcher.group(group);
        }
        return null;
    }
}
