package com.epam.batrachenko.task5.input_parameters_commands;

import com.epam.batrachenko.task5.chain_file_search.FileNameConstraint;
import com.epam.batrachenko.task5.chain_file_search.FileSearch;

import java.util.Scanner;

public class InputNameParameterCommand extends InputParameterCommand {
    @Override
    public void execute(FileSearch file) {
        System.out.println("Search by file name? Input 0 or 1");
        Scanner sc = new Scanner(System.in);
        int find = sc.nextInt();
        if (find == 1) {
            System.out.println("Input file name");
            sc.nextLine();
            file.add(new FileNameConstraint(sc.nextLine()));
        }
    }
}
