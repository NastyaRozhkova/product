package com.epam.batrachenko.task4.commands;

import com.epam.batrachenko.task1.Entity.Product;
import com.epam.batrachenko.task4.services.CartService;
import com.epam.batrachenko.task4.services.StoreService;
import com.epam.batrachenko.task4.util.Constants;

import java.util.Optional;
import java.util.Scanner;

public class AddProductCommand extends Command {
    @Override
    public boolean execute(StoreService store, CartService cart) {
        System.out.println(Constants.INPUT_PRODUCT_NAME);
        String name = new Scanner(System.in).nextLine();
        Optional<Product> findProduct = store.findProductByName(name);
        if (findProduct.isPresent()) {
            cart.addProduct(findProduct.get());
            System.out.println("Product was added");
            return true;
        } else {
            System.out.println("Product was not found");
            return false;
        }
    }

    @Override
    public String toString() {
        return "Add Product";
    }
}
