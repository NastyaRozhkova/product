package com.epam.batrachenko.task5.parameters;

import com.epam.batrachenko.task4.util.DateUtil;
import com.epam.batrachenko.task5.util.Parameter;

import java.util.Map;
import java.util.Scanner;

public class InputDateParameter implements InputParameter {
    @Override
    public void execute(Map<Parameter, String> parameters) {
        System.out.println("Search by file date? Input 0 or 1");
        Scanner sc = new Scanner(System.in);
        int find = sc.nextInt();
        if (find == 1) {
            System.out.println("Input file creation date (min and max)");
            parameters.put(Parameter.DATE, DateUtil.inputDate().toString() + "/" + DateUtil.inputDate().toString());
        }
    }
}
