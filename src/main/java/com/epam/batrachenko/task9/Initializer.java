package com.epam.batrachenko.task9;

import com.epam.batrachenko.task9.commands.CommandContainer;
import com.epam.batrachenko.task9.repository.ProductRepository;
import com.epam.batrachenko.task9.service.ProductService;

public interface Initializer {
    static CommandContainer initialize(String fileName) {
        return new CommandContainer(new ProductService(new ProductRepository(fileName)));
    }
}
