package com.epam.batrachenko.task9.http_command;

import java.util.HashMap;
import java.util.Map;

public class HttpCommandContainer {
    private final Map<String, HttpCommand> commands = new HashMap<>();

    public HttpCommandContainer() {
        commands.put("/shop/count", new ShopCount());
        commands.put("/shop/item", new GetItemInfo());
    }

    public Map<String, HttpCommand> getCommands() {
        return commands;
    }

    public HttpCommand getCommandByName(String name) {
        return commands.getOrDefault(name, new ErrorCommand());
    }

}
