package com.epam.batrachenko.task5.chain_file_search;

import java.io.File;
import java.util.List;

public abstract class FileParameterHandler {
    private FileParameterHandler nextHandler;

    public abstract List<File> handle(List<File> files);

    public void setNextHandler(FileParameterHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public List<File> handlerManager(List<File> files) {
        files = handle(files);
        if (nextHandler != null) {
            files = nextHandler.handlerManager(files);
        }
        return files;
    }
}
