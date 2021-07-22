package com.epam.batrachenko.task2.Iterator;

import com.epam.batrachenko.task1.Entity.Product;
import com.epam.batrachenko.task1.Iterator.ProductIterator;
import com.epam.batrachenko.task2.List.ProductWrapperList;

/**
 * An iterator over a collection of products,
 * that consists of unmodifiable and modifiable lists.
 *
 * @author Vladyslav Batrachenko
 * @see ProductWrapperList , Iterator, Iterable
 */
public class ProductWrapperListIterator<E extends Product> extends ProductIterator<E> {

    public ProductWrapperListIterator(ProductWrapperList<E> products) {
        super(products.getList());
    }
}
