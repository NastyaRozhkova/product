package com.epam.batrachenko.task1.Entity;

import com.epam.batrachenko.task7.field_annotaions.FieldTittle;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class Product implements Serializable {
    @FieldTittle(tittle = "name")
    protected String name;
    @FieldTittle(tittle = "price")
    protected BigDecimal price;
    @FieldTittle(tittle = "country")
    protected String country;

    public Product() {
    }

    public Product(String name, BigDecimal price, String country) {
        this.name = name;
        this.price = price;
        this.country = country;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String toString() {
        return "Product{name='" + this.name + "', price='" + this.price + "', country='" + this.country + "'}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name) && Objects.equals(price, product.price) && Objects.equals(country, product.country);
    }

    public int hashCode() {
        return Objects.hash(this.name, this.price, this.country);
    }
}

