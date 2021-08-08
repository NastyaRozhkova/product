package com.epam.batrachenko.task6.factory;

import com.epam.batrachenko.task1.Entity.Product;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProductCreate {
    protected Matcher matcher;

    public Product createProductFromString(String line) {
        this.matcher = Pattern.compile("(')([\\w,\\s]*)(')").matcher(line);
        return new Product(this.getField(this.matcher), new BigDecimal(this.getField(this.matcher)), this.getField(this.matcher));
    }

    protected String getField(Matcher matcher) {
        return matcher.find() ? matcher.group(2) : null;
    }
}

