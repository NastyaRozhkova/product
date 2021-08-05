package com.epam.batrachenko.task5.chain_file_search;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

public class FileExtensionConstraint extends FileParameterHandler {
    private String extension;

    public FileExtensionConstraint(String extension) {
        this.extension = extension;
    }

    @Override
    public List<File> handle(List<File> files) {
        return files.stream()
                .filter(file -> file.getAbsolutePath().endsWith(extension))
                .collect(Collectors.toList());
    }
}
