package com.epam.batrachenko.task9.tcp_command;

import com.epam.batrachenko.task9.service.ProductService;

public class GetCount extends TcpCommand {
    @Override
    public String execute(String request) {
        return new ProductService().getCountProducts();
    }
}
