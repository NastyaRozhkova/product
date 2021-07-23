package com.epam.batrachenko.task2.Iterator;

import com.epam.batrachenko.task1.Entity.Product;
import com.epam.batrachenko.task1.Iterator.ProductIterator;
import com.epam.batrachenko.task2.List.UnmodifiableAndModifiableProductList;

/**
 * An iterator over a collection of products,
 * that consists of unmodifiable and modifiable lists.
 *
 * @author Vladyslav Batrachenko
 * @see UnmodifiableAndModifiableProductList , Iterator, Iterable
 */
public class UnmodifiableAndModifiableProductListIterator<E extends Product> extends ProductIterator<E> {

    public UnmodifiableAndModifiableProductListIterator(UnmodifiableAndModifiableProductList<E> products) {
        super(products.getList());
    }
}
