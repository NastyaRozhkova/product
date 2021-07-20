package com.epam.batrachenko.task2.List;

import com.epam.batrachenko.task1.Entity.Product;
import com.epam.batrachenko.task1.List.ProductArrayList;

public class ProductListWithWrappers<E extends Product> extends ProductArrayList<E> {

    public static UnmodifiableProductList<Product> unmodifiableList(ProductListWithWrappers<Product> products) {
        return new UnmodifiableProductList<Product>(products);
    }
    public UnmodifiableProductList<E> unmodifiableList() {
        return new UnmodifiableProductList<>(this);
    }
    public ProductListWithWrappers() {
    }

    public ProductListWithWrappers(ProductArrayList<E> products) {
        super(products);
    }
}
