package com.epam.batrachenko.task2.Iterator;

import com.epam.batrachenko.task1.Entity.Product;
import com.epam.batrachenko.task2.List.ProductWrapperList;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * An iterator over a collection of products,
 * that consists of unmodifiable and modifiable lists.
 * @see ProductWrapperList , Iterator, Iterable
 * @author Vladyslav Batrachenko
 */
public class ProductWrapperListIterator<E extends Product> implements Iterator<E> {
    private final ProductWrapperList<E> productArrayList;
    private int index;

    public ProductWrapperListIterator(ProductWrapperList<E> products) {
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
