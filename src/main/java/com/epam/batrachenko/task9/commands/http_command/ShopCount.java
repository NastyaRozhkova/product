package com.epam.batrachenko.task9.commands.http_command;

import com.epam.batrachenko.task9.commands.Command;
import com.epam.batrachenko.task9.service.ProductService;

public class ShopCount extends Command {
    public ShopCount(ProductService productService) {
        super(productService);
    }

    @Override
    public String execute(String request) {
        return "{count:" + productService.getCountProducts() + "}";
    }
}
