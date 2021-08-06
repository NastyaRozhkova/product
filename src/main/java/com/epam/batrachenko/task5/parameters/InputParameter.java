package com.epam.batrachenko.task5.parameters;

import com.epam.batrachenko.task5.util.Parameter;

import java.util.Map;

public interface InputParameter {
    void execute(Map<Parameter, String> parameters);
}
