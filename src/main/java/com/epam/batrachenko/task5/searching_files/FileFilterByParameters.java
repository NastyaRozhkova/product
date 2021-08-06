package com.epam.batrachenko.task5.searching_files;

import com.epam.batrachenko.task5.chain.FileParameterFilter;
import com.epam.batrachenko.task5.util.Parameter;
import com.epam.batrachenko.task5.container.ParameterFilterContainer;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
        List<File> files = getAllFiles(path);
        linkParameters();
        return parameters.get(0).handlerManager(files);
    }

    public List<File> getAllFiles(String path) {
        List<File> files = new ArrayList<>();
        File[] newFiles = new File(path).listFiles();
        assert newFiles != null;
        for (File file : newFiles) {
            if (file.isDirectory()) {
                files.addAll(getAllFiles(file.getAbsolutePath()));
            } else {
                files.add(file);
            }
        }
        return files;
    }

    public void linkParameters() {
        for (int i = 0; i < parameters.size() - 1; i++) {
            parameters.get(i).setNextHandler(parameters.get(i + 1));
        }
    }

    public void addParameters(Map<Parameter, String> map) {
        Map<Parameter, Function<String, FileParameterFilter>> filters = new ParameterFilterContainer().getParameters();
        map.forEach((k, v) -> parameters.add(filters.get(k).apply(v)));
    }

}
