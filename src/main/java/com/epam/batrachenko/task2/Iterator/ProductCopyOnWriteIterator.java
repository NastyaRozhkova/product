package com.epam.batrachenko.task2.Iterator;

import com.epam.batrachenko.task1.Entity.Product;
import com.epam.batrachenko.task2.List.ProductCopyOnWriteList;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ProductCopyOnWriteIterator<E extends Product> implements Iterator<E> {
    private final E[] productArrayList;
    private int index;

    public ProductCopyOnWriteIterator(ProductCopyOnWriteList<E> products) {
        this.productArrayList = (E[]) products.toArray();
        this.index = -1;
    }

    public boolean hasNext() {
        return index < productArrayList.length - 1;
    }

    public E next() {
        if (hasNext()) {
            return productArrayList[++index];
        }
        throw new NoSuchElementException();
    }
}
