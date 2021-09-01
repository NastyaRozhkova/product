package com.epam.batrachenko.task9.tcp_command;

import com.epam.batrachenko.task1.Entity.Product;
import com.epam.batrachenko.task9.repository.ProductRepository;
import com.epam.batrachenko.task9.util.parsers.TcpRequestParser;

import java.util.Optional;

public class GetItem extends TcpCommand {
    @Override
    public String execute(String request) {
        String name = new TcpRequestParser().parseNameItemFromRequest(request);
        Optional<Product> product = new ProductRepository().getItemByName(name);
        return product.map(value -> value.getName() + "|" + value.getPrice())
                .orElse("No item with such name");
    }
}
