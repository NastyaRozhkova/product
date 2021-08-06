package com.epam.batrachenko.task5.parameters;

import com.epam.batrachenko.task4.util.DateUtil;
import com.epam.batrachenko.task5.util.Parameter;

import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InputDateParameter implements InputParameter {
    private static final Logger log = Logger.getLogger(InputDateParameter.class.getName());

    @Override
    public void execute(Map<Parameter, String> parameters) {
        log.log(Level.INFO, "Search by file date? Input 1");
        Scanner sc = new Scanner(System.in);
        int find = sc.nextInt();
        if (find == 1) {
            log.log(Level.INFO, "Input file creation date (min and max) in format 'dd-MM-yyyy'");
            parameters.put(Parameter.DATE, DateUtil.inputDateInString() + "/" + DateUtil.inputDateInString());
        }
    }
}
