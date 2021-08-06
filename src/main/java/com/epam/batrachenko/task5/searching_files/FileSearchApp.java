package com.epam.batrachenko.task5.searching_files;

import com.epam.batrachenko.task5.parameters.InputParameter;
import com.epam.batrachenko.task5.util.Parameter;
import com.epam.batrachenko.task5.container.ParametersContainer;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileSearchApp {
    private static final Logger log = Logger.getLogger(FileSearchApp.class.getName());

    public static void searchingFilesByPath(String path) {
        Map<Parameter, String> parameters = new LinkedHashMap<>();
        for (InputParameter parameter : new ParametersContainer().getParameters()) {
            parameter.execute(parameters);
        }
        FileFilterByParameters file = new FileFilterByParameters();
        file.addParameters(parameters);
        log.log(Level.INFO, "Found files:");

        printFiles(file.search(path));
    }

    public static void printFiles(List<File> files) {
        for (File file : files) {
            log.log(Level.INFO, file.getName());
        }
    }
}
