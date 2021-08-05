package com.epam.batrachenko.task5.input_parameters_commands;

import java.util.ArrayList;
import java.util.List;

public class InputCommandContainer {
    private static ArrayList<InputParameterCommand> commands = new ArrayList<>();

    static {
        commands.add(new InputNameParameterCommand());
        commands.add(new InputExtensionParameterCommand());
        commands.add(new InputSizeParameterCommand());
        commands.add(new InputDateParameterCommand());
    }

    public static List<InputParameterCommand> getCommands() {
        return commands;
    }
}
