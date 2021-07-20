package com.epam.batrachenko.task2.List;

import com.epam.batrachenko.task1.Entity.Product;
import com.epam.batrachenko.task1.List.ProductArrayList;
import com.epam.batrachenko.task2.Iterator.ProductCopyOnWriteIterator;

import java.lang.reflect.Array;
import java.util.*;

public class ProductCopyOnWriteList<E extends Product> extends ProductArrayList<E> implements List<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private E[] array;
    private int size;

    public ProductCopyOnWriteList() {
        this.array = (E[]) new Product[DEFAULT_CAPACITY];
        this.size = 0;
    }

    public ProductCopyOnWriteList(Class<E> dataType, int capacity) {
        this.array = (E[]) Array.newInstance(dataType, capacity);
        this.size = 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new ProductCopyOnWriteIterator<>(this);
    }

}

