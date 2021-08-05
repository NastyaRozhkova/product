package com.epam.batrachenko.task5.input_parameters_commands;

import com.epam.batrachenko.task5.chain_file_search.FileSearch;

public abstract class InputParameterCommand {
    public abstract void execute(FileSearch file);
}
