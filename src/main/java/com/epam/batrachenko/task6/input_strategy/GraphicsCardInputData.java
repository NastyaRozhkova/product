package com.epam.batrachenko.task6.input_strategy;

import com.epam.batrachenko.task1.Entity.ComputerPart;
import com.epam.batrachenko.task1.Entity.GraphicsCard;
import com.epam.batrachenko.task1.Entity.Product;
import com.epam.batrachenko.task6.utils.InputConstants;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

import java.util.Scanner;

public class GraphicsCardInputData extends ComputerPartInputData {
    private static final Logger log = LoggerFactory.getLogger(GraphicsCardInputData.class);

    @Override
    public Product inputDataFromConsole() {
        Scanner sc = new Scanner(System.in);
        ComputerPart p = (ComputerPart) super.inputDataFromConsole();
        log.trace(InputConstants.INPUT_MEMORY);
        int memory = sc.nextInt();
        log.trace(InputConstants.INPUT_MEMORY_TYPE);
        String memoryType = sc.nextLine();
        log.trace(InputConstants.INPUT_CONNECTOR);
        String connector = sc.nextLine();
        return new GraphicsCard(p.getName(), p.getPrice(), p.getCountry(), p.getCategory(), p.getPurpose(), memory, memoryType, connector);
    }

    @Override
    public String toString() {
        return "GraphicsCard";
    }
}
