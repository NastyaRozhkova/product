package com.epam.batrachenko.task4.commands;

import java.util.Map;
import java.util.TreeMap;

public class CommandContainer {
    private static Map<Integer, Command> commands = new TreeMap<>();

    static {
        commands.put(0, new Exit());
        commands.put(1, new AddProduct());
        commands.put(2, new FindOrdersByPeriod());
        commands.put(3,new GetFirstOrderSortedByDate());
        commands.put(4,new MakeOrder());
        commands.put(5, new PrintLastFiveProducts());
        commands.put(6,new PrintStoreProducts());
        commands.put(7,new PrintShoppingCart());
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
