package com.epam.batrachenko.task5.searching_files;

import com.epam.batrachenko.task5.parameters.*;
import com.epam.batrachenko.task5.util.Parameter;
import com.epam.batrachenko.task5.util.ParametersContainer;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class FileSearchApp {
    public List<InputParameter> commands = new ArrayList<>();

    {
        commands.add(new InputNameParameter());
        commands.add(new InputExtensionParameter());
        commands.add(new InputSizeParameter());
        commands.add(new InputDateParameter());
    }

    public static void main() {
        Map<Parameter, String> parameters = new LinkedHashMap<>();
        for (InputParameter parameter : ParametersContainer.getParameters()) {
            parameter.execute(parameters);
        }
        FileFilterByParameters file = new FileFilterByParameters();
        file.addParameters(parameters);
        System.out.println("Found files:");

        printFiles(file.search("D:"));
    }

    public static void printFiles(List<File> files) {
        for (File file : files) {
            System.out.println(file.getName());
        }
    }
}
