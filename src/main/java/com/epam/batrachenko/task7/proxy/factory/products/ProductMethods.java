package com.epam.batrachenko.task7.proxy.factory.products;

import java.math.BigDecimal;

public interface ProductMethods {
    void setName(String name);

    void setPrice(BigDecimal price);

    void setCountry(String country);

    BigDecimal getPrice();

    String getCountry();

    String getName();
}
