package com.epam.batrachenko.task9.service;

import com.epam.batrachenko.task1.Entity.Product;
import com.epam.batrachenko.task3.List.UniqueProductArrayList;
import com.epam.batrachenko.task9.repository.ProductRepository;

import java.util.Optional;

public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public String getCountProducts() {
        UniqueProductArrayList<Product> products = productRepository.getListProducts();
        return String.valueOf(products.size());
    }

    public Optional<Product> getProductByName(String name) {
        return productRepository.getItemByName(name);
    }
}
