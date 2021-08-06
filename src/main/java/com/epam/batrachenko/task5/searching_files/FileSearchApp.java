package com.epam.batrachenko.task5.searching_files;

import com.epam.batrachenko.task5.container.ParametersContainer;
import com.epam.batrachenko.task5.parameters.InputParameter;
import com.epam.batrachenko.task5.util.Parameter;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class FileSearchApp {
    private static final Logger log = LoggerFactory.getLogger(FileSearchApp.class);

    public static void searchingFilesByPath(String path) {
        Map<Parameter, String> parameters = new LinkedHashMap<>();
        for (InputParameter parameter : new ParametersContainer().getParameters()) {
            parameter.execute(parameters);
        }
        FileFilterByParameters file = new FileFilterByParameters();
        file.addParameters(parameters);
        log.trace("Found files:");

        printFiles(file.search(path));
    }

    public static void printFiles(List<File> files) {
        for (File file : files) {
            log.trace(file.getName());
        }
    }
}
