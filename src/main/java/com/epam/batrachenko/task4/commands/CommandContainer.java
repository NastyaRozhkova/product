package com.epam.batrachenko.task4.commands;

import java.util.Map;
import java.util.TreeMap;

public class CommandContainer {
    private static Map<Integer, Command> commands = new TreeMap<>();

    static {
        commands.put(0, new ExitCommand());
        commands.put(1, new AddProductCommand());
        commands.put(2, new FindOrdersByPeriodCommand());
        commands.put(3, new GetFirstOrderSortedByDateCommand());
        commands.put(4, new MakeOrderCommand());
        commands.put(5, new PrintLastFiveProductsCommand());
        commands.put(6, new PrintStoreProductsCommand());
        commands.put(7, new PrintShoppingCartCommand());
    }

    public static Command get(int code) {
        if (!commands.containsKey(code)) {
            return new ErrorCommand();
        }
        return commands.get(code);
    }

    public static Map<Integer, Command> getCommands() {
        return commands;
    }
}
