package com.epam.batrachenko.task2.List;

import com.epam.batrachenko.task1.Entity.Product;
import com.epam.batrachenko.task1.List.ProductArrayList;

import java.util.Collection;

public class UnmodifiableProductList<E extends Product> extends ProductListWithWrappers<E> {

    public UnmodifiableProductList(ProductArrayList<E> products) {
        super(products);
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override
    public E set(int index, E element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public E remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean add(E e) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }
}
