package com.epam.batrachenko.task5.util;

import com.epam.batrachenko.task5.parameters.*;

import java.util.ArrayList;
import java.util.List;

public class ParametersContainer {
    private static ArrayList<InputParameter> parameters = new ArrayList<>();

    static {
        parameters.add(new InputNameParameter());
        parameters.add(new InputExtensionParameter());
        parameters.add(new InputSizeParameter());
        parameters.add(new InputDateParameter());
    }

    public static List<InputParameter> getParameters() {
        return parameters;
    }
}
