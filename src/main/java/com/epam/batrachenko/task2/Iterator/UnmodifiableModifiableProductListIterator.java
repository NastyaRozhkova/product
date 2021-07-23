package com.epam.batrachenko.task2.Iterator;

import com.epam.batrachenko.task1.Entity.Product;
import com.epam.batrachenko.task1.Iterator.ProductIterator;
import com.epam.batrachenko.task2.List.UnmodifiableModifiableProductList;

/**
 * An iterator over a collection of products,
 * that consists of unmodifiable and modifiable lists.
 *
 * @author Vladyslav Batrachenko
 * @see UnmodifiableModifiableProductList , Iterator, Iterable
 */
public class UnmodifiableModifiableProductListIterator<E extends Product> extends ProductIterator<E> {

    public UnmodifiableModifiableProductListIterator(UnmodifiableModifiableProductList<E> products) {
        super(products.getList());
    }
}
