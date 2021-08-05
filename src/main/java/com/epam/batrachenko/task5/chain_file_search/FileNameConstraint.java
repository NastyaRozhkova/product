package com.epam.batrachenko.task5.chain_file_search;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

public class FileNameConstraint extends FileParameterHandler {
    private String name;

    public FileNameConstraint(String name) {
        this.name = name;
    }

    @Override
    public List<File> handle(List<File> files) {
        return files.stream()
                .filter(f -> f.getName().contains(this.name))
                .collect(Collectors.toList());
    }

}
