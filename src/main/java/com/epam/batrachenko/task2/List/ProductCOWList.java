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

    public ProductCOWList() {
    }

    public ProductCOWList(ProductArrayList<E> products) {
        super(products);
        this.array = (E[]) new Product[products.size()];
        this.size = products.size();
        System.arraycopy(products.toArray(array), 0, this.array, 0, this.size);
    }

    @Override
    public Iterator<E> iterator() {
        return new ProductCOWIterator<>(this);
    }

    @Override
    public void clear() {
        E[] products = (E[]) new Product[DEFAULT_CAPACITY];
        int sizeCopy = 0;
        setArray(products, sizeCopy);
    }

    @Override
    public E set(int index, E element) {
        E[] products = getArray();
        int sizeCopy = this.size;
        products[index] = element;
        setArray(products, sizeCopy);
        return products[index];
    }

    @Override
    public void add(int index, E element) {
        E[] products = getArray();
        int sizeCopy = this.size;
        if (products.length == sizeCopy) {
            E[] newArray = (E[]) new Product[products.length + 1];
            System.arraycopy(products, 0, newArray, 0, index);
            System.arraycopy(products, index, newArray, index + 1, sizeCopy - index);
            products = newArray;
        } else {
            System.arraycopy(products, index, products, index + 1, sizeCopy - index);
        }
        products[index] = element;
        ++sizeCopy;
        setArray(products, sizeCopy);
    }

    @Override
    public E remove(int index) {
        E[] products = getArray();
        int sizeCopy = this.size;
        E temp = products[index];
        if (index + 1 == sizeCopy) {
            products[index] = null;
        } else {
            System.arraycopy(products, index + 1, products, index, sizeCopy - index);
        }
        --sizeCopy;
        setArray(products, sizeCopy);
        return temp;
    }

    @Override
    public boolean add(E e) {
        this.add(this.size, e);
        return true;
    }

    private E[] getArray() {
        return this.array;
    }

    private void setArray(E[] a, int size) {
        array = a;
        this.size = size;
    }
}

