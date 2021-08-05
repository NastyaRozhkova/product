package com.epam.batrachenko.task5.input_parameters_commands;

import com.epam.batrachenko.task5.chain_file_search.FileSearch;
import com.epam.batrachenko.task5.chain_file_search.FileSizeConstraint;

import java.util.Scanner;

public class InputSizeParameterCommand extends InputParameterCommand {
    @Override
    public void execute(FileSearch file) {
        System.out.println("Search by file size? Input 0 or 1");
        Scanner sc = new Scanner(System.in);
        int find = sc.nextInt();
        if (find == 1) {
            System.out.println("Input file size (min and max)");
            file.add(new FileSizeConstraint(sc.nextInt(), sc.nextInt()));
        }
    }
}
