package com.epam.batrachenko.task9.tcp_command;

import java.util.HashMap;
import java.util.Map;

public class TcpCommandContainer {
    private final Map<String, TcpCommand> commands = new HashMap<>();

    public TcpCommandContainer() {
        commands.put("get count", new GetCount());
        commands.put("get item", new GetItem());
    }

    public Map<String, TcpCommand> getCommands() {
        return commands;
    }

    public TcpCommand getCommandByName(String name) {
        return commands.getOrDefault(name, new UnknownCommand());
    }

}
