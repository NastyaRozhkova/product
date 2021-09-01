package com.epam.batrachenko.task9.util;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class JSONPrinter {
    public void printInJson(BufferedWriter output, String text) throws IOException {
        output.write("HTTP/1.1 200 OK\r\n");
        output.write("Content-Type: text/html; charset=utf-8\r\n");
        output.write("\r\n");
        output.write("<p>" + text + "</p>");
        output.flush();
    }
}
