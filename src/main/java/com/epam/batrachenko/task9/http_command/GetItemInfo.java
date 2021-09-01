package com.epam.batrachenko.task9.http_command;

import com.epam.batrachenko.task1.Entity.Product;
import com.epam.batrachenko.task9.util.parsers.HttpRequestParser;
import com.epam.batrachenko.task9.repository.ProductRepository;

import java.util.Optional;

public class GetItemInfo extends HttpCommand {
    @Override
    public String execute(String request) {
        String name = new HttpRequestParser().parseNameFromRequest(request);
        Optional<Product> product = new ProductRepository().getItemByName(name);
        return product.map(value -> "{name:" + value.getName() + ",price:" + value.getPrice() + "}")
                .orElse("No item with such name");
    }
}
