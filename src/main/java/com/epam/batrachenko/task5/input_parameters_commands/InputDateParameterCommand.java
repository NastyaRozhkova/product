package com.epam.batrachenko.task5.input_parameters_commands;

import com.epam.batrachenko.task4.util.DateUtil;
import com.epam.batrachenko.task5.chain_file_search.FileDateConstraint;
import com.epam.batrachenko.task5.chain_file_search.FileSearch;

import java.util.Scanner;

public class InputDateParameterCommand extends InputParameterCommand {
    @Override
    public void execute(FileSearch file) {
        System.out.println("Search by file date? Input 0 or 1");
        Scanner sc = new Scanner(System.in);
        int find = sc.nextInt();
        if (find == 1) {
            System.out.println("Input file creation date (min and max)");
            file.add(new FileDateConstraint(DateUtil.inputDate(), DateUtil.inputDate()));
        }
    }
}
