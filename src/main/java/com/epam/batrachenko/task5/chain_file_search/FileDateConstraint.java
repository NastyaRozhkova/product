package com.epam.batrachenko.task5.chain_file_search;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class FileDateConstraint extends FileParameterHandler {
    private Date minDate;
    private Date maxDate;

    public FileDateConstraint(Date minDate, Date maxDate) {
        this.minDate = minDate;
        this.maxDate = maxDate;
    }

    @Override
    public List<File> handle(List<File> files) {
        return files.stream()
                .filter(file -> new Date(file.lastModified()).after(minDate) && new Date(file.lastModified()).before(maxDate))
                .collect(Collectors.toList());
    }
}
