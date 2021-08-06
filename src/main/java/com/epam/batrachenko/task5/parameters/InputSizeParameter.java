package com.epam.batrachenko.task5.parameters;

import com.epam.batrachenko.task5.util.Parameter;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

import java.util.Map;
import java.util.Scanner;


public class InputSizeParameter implements InputParameter {
    private static final Logger log = LoggerFactory.getLogger(InputSizeParameter.class);

    @Override
    public void execute(Map<Parameter, String> parameters) {
        log.trace("Search by size name? Input 1");
        Scanner sc = new Scanner(System.in);
        int find = sc.nextInt();
        if (find == 1) {
            log.trace("Input file size (min and max)");
            parameters.put(Parameter.SIZE, "" + sc.nextInt() + "/" + sc.nextInt());
        }
    }
}
