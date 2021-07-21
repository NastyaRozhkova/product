package com.epam.batrachenko.task1.Entity;
import java.math.BigDecimal;
import java.util.Objects;

public class Accessories extends Product {
    private String type;
    private String brand;

    public Accessories() {
    }

    public Accessories(String name, BigDecimal price, String country, String type, String brand) {
        super(name, price, country);
        this.type = type;
        this.brand = brand;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return this.brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String toString() {
        return "Accessories{type='" + this.type + "', brand='" + this.brand + "'}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Accessories that = (Accessories) o;
        return Objects.equals(type, that.type) && Objects.equals(brand, that.brand);
    }

    public int hashCode() {
        return Objects.hash(super.hashCode(), this.type, this.brand);
    }
}

