package com.epam.batrachenko.task5.parameters;

import com.epam.batrachenko.task5.util.Parameter;

import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InputNameParameter implements InputParameter {
    private static final Logger log = Logger.getLogger(InputNameParameter.class.getName());

    @Override
    public void execute(Map<Parameter, String> parameters) {
        log.log(Level.INFO,"Search by file name? Input 1");
        Scanner sc = new Scanner(System.in);
        int find = sc.nextInt();
        if (find == 1) {
            log.log(Level.INFO,"Input file name");
            sc.nextLine();
            parameters.put(Parameter.NAME,sc.nextLine());
        }
    }
}
