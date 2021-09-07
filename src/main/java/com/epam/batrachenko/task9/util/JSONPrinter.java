package com.epam.batrachenko.task9.util;

import java.io.BufferedWriter;
import java.io.IOException;

public class JSONPrinter {
    public void printInJson(BufferedWriter output, String text) throws IOException {
        output.write("HTTP/1.1 200 OK");
        output.newLine();
        output.write("Content-Type: text/html; charset=utf-8");
        output.newLine();
        output.newLine();
        output.write("<p>" + text + "</p>");
        output.flush();
    }
}
