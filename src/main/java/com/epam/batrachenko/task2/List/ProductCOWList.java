package com.epam.batrachenko.task2.List;

import com.epam.batrachenko.task1.Entity.Product;
import com.epam.batrachenko.task1.List.ProductArrayList;
import com.epam.batrachenko.task2.Iterator.ProductCOWIterator;

import java.util.Iterator;
import java.util.List;

/**
 * Copy on write collection of products.
 * The methods that change data create new data array and after execute save it to list.
 *
 * @author Vladyslav Batrachenko
 * @see Product , ProductArrayList, List
 */
public class ProductCOWList<E extends Product> extends ProductArrayList<E> implements List<E> {

    @Override
    public Iterator<E> iterator() {
        return new ProductCOWIterator<>(new ProductCOWList<>(this));
    }

    public ProductCOWList() {
    }

    public ProductCOWList(ProductArrayList<E> products) {
        super(products);
    }
}

