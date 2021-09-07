package com.epam.batrachenko.task9.commands;

import com.epam.batrachenko.task9.commands.http_command.GetItemInfo;
import com.epam.batrachenko.task9.commands.http_command.ShopCount;
import com.epam.batrachenko.task9.commands.tcp_command.GetCount;
import com.epam.batrachenko.task9.commands.tcp_command.GetItem;
import com.epam.batrachenko.task9.service.ProductService;

import java.util.HashMap;
import java.util.Map;

public class CommandContainer {
    public final Command errorCommand;
    private final Map<String, Command> commands = new HashMap<>();

    public Map<String, Command> getCommands() {
        return commands;
    }

    public Command getCommandByName(String name) {
        return commands.getOrDefault(name, errorCommand);
    }

    public CommandContainer(ProductService productService) {
        errorCommand = new ErrorCommand(productService);
        commands.put("/shop/count", new ShopCount(productService));
        commands.put("/shop/item", new GetItemInfo(productService));
        commands.put("get count", new GetCount(productService));
        commands.put("get item", new GetItem(productService));
    }
}
