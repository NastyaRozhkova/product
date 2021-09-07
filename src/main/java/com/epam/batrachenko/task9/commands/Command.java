package com.epam.batrachenko.task9.commands;

import com.epam.batrachenko.task9.service.ProductService;

public abstract class Command {
    protected final ProductService productService;

    protected Command(ProductService productService) {
        this.productService = productService;
    }

    public abstract String execute(String request);
}
