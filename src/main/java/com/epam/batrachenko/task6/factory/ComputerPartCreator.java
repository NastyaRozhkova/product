package com.epam.batrachenko.task6.factory;

import com.epam.batrachenko.task1.Entity.ComputerPart;
import com.epam.batrachenko.task1.Entity.Product;

public class ComputerPartCreator extends ProductCreator {
    @Override
    public Product createProductFromString(String line) {
        Product p = super.createProductFromString(line);
        return new ComputerPart(p.getName(), p.getPrice(), p.getCountry(), this.getField(this.matcher), this.getField(this.matcher));
    }
}
