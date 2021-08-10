package com.epam.batrachenko.task6.factory;

import com.epam.batrachenko.task1.Entity.Accessories;
import com.epam.batrachenko.task1.Entity.Product;

public class AccessoriesCreator extends ProductCreator {

    @Override
    public Product createProductFromString(String line) {
        Product p = super.createProductFromString(line);
        return new Accessories(p.getName(), p.getPrice(), p.getCountry(), this.getField(this.matcher), this.getField(this.matcher));
    }
}
