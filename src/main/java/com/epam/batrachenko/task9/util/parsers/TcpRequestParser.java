package com.epam.batrachenko.task9.util.parsers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TcpRequestParser {
    public String parseNameItemFromRequest(String request) {
        Pattern pattern = Pattern.compile("(item=)(\\w+)");
        Matcher matcher = pattern.matcher(request);
        if (matcher.find()) {
            return matcher.group(2);
        }
        return null;
    }

    public String parseNameCommandFromRequest(String request) {
        Pattern pattern = Pattern.compile("([\\w ]+)(=*)");
        Matcher matcher = pattern.matcher(request);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }
}
