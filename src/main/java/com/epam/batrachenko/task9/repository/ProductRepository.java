package com.epam.batrachenko.task9.repository;

import com.epam.batrachenko.task1.Entity.Product;
import com.epam.batrachenko.task3.List.UniqueProductArrayList;
import com.epam.batrachenko.task6.file_handler.ProductContainerFilesHandler;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

import java.io.IOException;
import java.util.Optional;

public class ProductRepository {
    private static final Logger log = LoggerFactory.getLogger(ProductRepository.class);
    private final UniqueProductArrayList<Product> products = new UniqueProductArrayList<>();

    public ProductRepository(ProductContainerFilesHandler containerFilesHandler, String fileName) {
        try {
            products.addAll(containerFilesHandler.load(fileName));
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
    }

    public UniqueProductArrayList<Product> getListProducts() {
        return products;
    }

    public Optional<Product> getItemByName(String name) {
        return getListProducts().stream()
                .filter(p -> p.getName().equals(name))
                .findFirst();
    }
}
