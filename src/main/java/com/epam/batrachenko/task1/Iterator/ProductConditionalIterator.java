package com.epam.batrachenko.task1.Iterator;

import com.epam.batrachenko.task1.Entity.Product;
import com.epam.batrachenko.task1.List.ProductArrayList;

import java.util.NoSuchElementException;
import java.util.function.Predicate;

/**
 * An iterator over a collection of products.
 * Iterator contains the condition for iterating over the collection, that is,
 * only those elements of the collection that match the condition are returned.
 * @see ProductArrayList, ProductIterator, Predicate
 * @author Vladyslav Batrachenko
 * @param <E> – the type of elements returned by this iterator
 */
public class ProductConditionalIterator<E extends Product> extends ProductIterator<E> {
    Predicate<E> condition;

    public ProductConditionalIterator(Predicate<E> condition, ProductArrayList<E> products) {
        super(products);
        this.condition = condition;
    }

    public boolean hasNext() {
        for (int temp = this.index+1; temp < productArrayList.size(); ++temp) {
            if (this.condition.test((E) productArrayList.toArray()[temp])) {
                return true;
            }
        }
        return false;
    }

    public E next() {
        while (this.index + 1 < productArrayList.size()) {
            if (this.condition.test(((E) productArrayList.toArray()[++index]))) {
                return ((E) productArrayList.toArray()[index]);
            }
        }
        throw new NoSuchElementException();
    }
}
