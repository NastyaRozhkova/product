package com.epam.batrachenko.task5.util;

import com.epam.batrachenko.task5.chain.*;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class ParameterFilterContainer {
    private static Map<Parameter, Function<String, FileParameterFilter>> parameterFilters = new HashMap<>();

    static {
        parameterFilters.put(Parameter.NAME, FileNameFilter::new);
        parameterFilters.put(Parameter.EXTENSION, FileExtensionFilter::new);
        parameterFilters.put(Parameter.SIZE, FileSizeFilter::new);
        parameterFilters.put(Parameter.DATE, FileDateFilter::new);
    }

    public static Map<Parameter, Function<String, FileParameterFilter>> getParameters() {
        return parameterFilters;
    }
}
