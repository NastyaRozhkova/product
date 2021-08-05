package com.epam.batrachenko.task5.chain_file_search;

import com.epam.batrachenko.task4.repository.ConsoleStoreRepository;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Contain methods for searching files by criteria and adding criteria.
 *
 * @author Vladyslav Batrachenko
 * @see FileParameterHandler
 */
public class FileSearch {
    private ArrayList<FileParameterHandler> parameters = new ArrayList<>();

    public FileSearch() {
    }

    public void add(FileParameterHandler f) {
        this.parameters.add(f);
    }

    public List<File> search(String path) {
        List<File> files = Arrays.asList(Objects.requireNonNull(new File(path).listFiles()));
        linkParameters();
        return parameters.get(0).handlerManager(files);
    }

    public void linkParameters() {
        for (int i = 0; i < parameters.size() - 1; i++) {
            parameters.get(i).setNextHandler(parameters.get(i + 1));
        }
    }

}
