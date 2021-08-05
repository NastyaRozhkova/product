package com.epam.batrachenko.task5.chain_file_search;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

public class FileSizeConstraint extends FileParameterHandler {
    private int minSize;
    private int maxSize;

    public FileSizeConstraint(int minSize, int maxSize) {
        this.minSize = minSize;
        this.maxSize = maxSize;
    }

    @Override
    public List<File> handle(List<File> files) {
        return files.stream()
                .filter(file -> file.length() >= minSize && file.length() <= maxSize)
                .collect(Collectors.toList());
    }
}
