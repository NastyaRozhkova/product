package com.epam.batrachenko.task6.factory;

import com.epam.batrachenko.task1.Entity.ComputerPart;
import com.epam.batrachenko.task1.Entity.GraphicsCard;
import com.epam.batrachenko.task1.Entity.Product;

public class GraphicsCardCreate extends ComputerPartCreate {

    @Override
    public Product createProductFromString(String line) {
        ComputerPart p = (ComputerPart) super.createProductFromString(line);
        return new GraphicsCard(p.getName(), p.getPrice(), p.getCountry(), p.getCategory(), p.getPurpose(), Integer.parseInt(this.getField(this.matcher)), this.getField(this.matcher), this.getField(this.matcher));
    }
}

