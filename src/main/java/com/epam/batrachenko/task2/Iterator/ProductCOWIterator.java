package com.epam.batrachenko.task2.Iterator;

import com.epam.batrachenko.task1.Entity.Product;
import com.epam.batrachenko.task2.List.ProductCOWList;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * An iterator over a collection of products and resistant to data change.
 * @see ProductCOWList , Iterator, Iterable
 * @author Vladyslav Batrachenko
 */
public class ProductCOWIterator<E extends Product> implements Iterator<E> {
    private final ProductCOWList<E> productArrayList;
    private int index;

    public ProductCOWIterator(ProductCOWList<E> products) {
        this.productArrayList = new ProductCOWList<>(products);
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
