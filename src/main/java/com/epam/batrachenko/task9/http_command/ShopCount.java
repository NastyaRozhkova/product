package com.epam.batrachenko.task9.http_command;

import com.epam.batrachenko.task9.service.ProductService;

public class ShopCount extends HttpCommand {
    @Override
    public String execute(String request) {
        return "{count:" + new ProductService().getCountProducts() + "}";
    }
}
