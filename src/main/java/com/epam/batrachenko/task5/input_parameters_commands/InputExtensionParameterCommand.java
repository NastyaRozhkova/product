package com.epam.batrachenko.task5.input_parameters_commands;

import com.epam.batrachenko.task5.chain_file_search.FileExtensionConstraint;
import com.epam.batrachenko.task5.chain_file_search.FileSearch;

import java.util.Scanner;

public class InputExtensionParameterCommand extends InputParameterCommand {
    @Override
    public void execute(FileSearch file) {
        System.out.println("Search by file extension? Input 0 or 1");
        Scanner sc = new Scanner(System.in);
        int find = sc.nextInt();
        if (find == 1) {
            System.out.println("Input file extension");
            sc.nextLine();
            file.add(new FileExtensionConstraint(sc.nextLine()));
        }
    }
}
