package com.epam.batrachenko.task1.Iterator;

import com.epam.batrachenko.task1.Entity.Product;
import com.epam.batrachenko.task1.List.ProductArrayList;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ProductIterator<E extends Product> implements Iterator<E> {
    protected ProductArrayList<E> productArrayList;
    protected int index;

    public ProductIterator(ProductArrayList<E> products) {
        this.productArrayList = products;
        this.index = -1;
    }

    public boolean hasNext() {
        return index < productArrayList.size() - 1;
    }

    public E next() {
        if (hasNext()) {
            return productArrayList.get(++index);
        }
        throw new NoSuchElementException();
    }
}
