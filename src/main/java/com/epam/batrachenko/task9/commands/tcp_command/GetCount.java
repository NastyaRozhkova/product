package com.epam.batrachenko.task9.commands.tcp_command;

import com.epam.batrachenko.task9.commands.Command;
import com.epam.batrachenko.task9.service.ProductService;

public class GetCount extends Command {
    public GetCount(ProductService productService) {
        super(productService);
    }

    @Override
    public String execute(String request) {
        return productService.getCountProducts();
    }
}
