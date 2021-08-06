package com.epam.batrachenko.task5.searching_files;

import com.epam.batrachenko.task5.chain.FileParameterFilter;
import com.epam.batrachenko.task5.util.Parameter;
import com.epam.batrachenko.task5.util.ParameterFilterContainer;

import java.io.File;
import java.util.*;
import java.util.function.Function;

/**
 * Contain methods for searching files by criteria and adding criteria.
 *
 * @author Vladyslav Batrachenko
 * @see FileParameterFilter
 */
public class FileFilterByParameters {
    private List<FileParameterFilter> parameters = new ArrayList<>();

    public FileFilterByParameters() {
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

    public void addParameters(Map<Parameter, String> map) {
        Map<Parameter, Function<String, FileParameterFilter>> filters = ParameterFilterContainer.getParameters();
        map.forEach((k, v) -> {
            parameters.add(filters.get(k).apply(v));
        });
    }

}
