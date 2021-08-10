package com.epam.batrachenko.task6.file_handler;

import com.epam.batrachenko.task1.Entity.Product;
import com.epam.batrachenko.task3.List.UniqueProductArrayList;
import com.epam.batrachenko.task5.read_file_wrappers.ReadTextFileWrapper;
import com.epam.batrachenko.task6.container.TypeProductsContainer;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * Contains methods for saving product container to file or
 * loading product container from file.
 *
 * @author Vladyslav_Batrachenko
 */
public class ProductContainerFilesHandler {

    public void save(List<Product> products, String path) throws IOException {
        try (RandomAccessFile file = new RandomAccessFile(new File(path), "rw")) {
            file.setLength(0L);
            for (Product product : products) {
                file.write((product.toString() + System.lineSeparator()).getBytes(StandardCharsets.UTF_8));
            }
        }
    }

    public List<Product> load(String path) throws IOException {
        List<Product> products = new ArrayList<>();
        try (ReadTextFileWrapper file = new ReadTextFileWrapper(path)) {
            for (String line : file) {
                products.add((new TypeProductsContainer()).getTypeProducts(line).createProductFromString(line));
            }
        }
        return products;
    }
}
