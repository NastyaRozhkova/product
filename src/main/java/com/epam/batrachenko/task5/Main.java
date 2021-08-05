package com.epam.batrachenko.task5;

import com.epam.batrachenko.task5.chain_file_search.FileSearch;
import com.epam.batrachenko.task5.input_parameters_commands.InputCommandContainer;
import com.epam.batrachenko.task5.input_parameters_commands.InputParameterCommand;

import java.io.File;
import java.util.List;

public class Main {
    public static void main(String... args) {
        FileSearch file = new FileSearch();
        for (InputParameterCommand temp : InputCommandContainer.getCommands()) {
            temp.execute(file);
        }

        System.out.println("Found files:");
        printFiles(file.search("D:"));
    }

    public static void printFiles(List<File> files) {
        for (File file : files) {
            System.out.println(file.getName());
        }
    }
}
