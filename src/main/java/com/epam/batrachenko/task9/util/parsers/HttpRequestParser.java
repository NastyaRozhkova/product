package com.epam.batrachenko.task9.util.parsers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HttpRequestParser {
    public String parseNameFromRequest(String request) {
        Pattern pattern = Pattern.compile("(item\\?get_info=)(\\w+)([ &])");
        Matcher matcher = pattern.matcher(request);
        if (matcher.find()) {
            return matcher.group(2);
        }
        return null;
    }

    public String parseNameCommandFromRequest(String request) {
        Pattern pattern = Pattern.compile("(GET )([\\w/]+)( ?)");
        Matcher matcher = pattern.matcher(request);
        if (matcher.find()) {
            return matcher.group(2);
        }
        return null;
    }
}
