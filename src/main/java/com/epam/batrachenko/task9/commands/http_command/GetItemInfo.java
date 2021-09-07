package com.epam.batrachenko.task9.commands.http_command;

import com.epam.batrachenko.task1.Entity.Product;
import com.epam.batrachenko.task9.commands.Command;
import com.epam.batrachenko.task9.service.ProductService;
import com.epam.batrachenko.task9.util.Constants;
import com.epam.batrachenko.task9.util.Parser;

import java.util.Optional;

public class GetItemInfo extends Command {
    public GetItemInfo(ProductService productService) {
        super(productService);
    }

    @Override
    public String execute(String request) {
        String name = Parser.parseFromRequest(Constants.HTTP_GET_PRODUCT_NAME, 2, request);
        Optional<Product> product = productService.getProductByName(name);
        return product.map(value -> "{name:" + value.getName() + ",price:" + value.getPrice() + "}")
                .orElse("No item with such name");
    }
}
