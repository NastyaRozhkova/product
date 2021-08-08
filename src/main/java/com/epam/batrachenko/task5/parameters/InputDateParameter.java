package com.epam.batrachenko.task5.parameters;

import com.epam.batrachenko.task4.util.DateUtil;
import com.epam.batrachenko.task5.util.Parameter;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

import java.util.Map;
import java.util.Scanner;


public class InputDateParameter implements InputParameter {
    private static final Logger log = LoggerFactory.getLogger(InputDateParameter.class);

    @Override
    public void execute(Map<Parameter, String> parameters) {
        log.trace("Search by file date? Input 1");
        Scanner sc = new Scanner(System.in);
        int find = sc.nextInt();
        if (find == 1) {
            log.trace("Input file creation date (min and max) in format 'dd-MM-yyyy'");
            parameters.put(Parameter.DATE, DateUtil.inputDateInString() + "/" + DateUtil.inputDateInString());
        }
    }
}