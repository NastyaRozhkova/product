package com.epam.batrachenko.task3.List;

import com.epam.batrachenko.task1.Entity.Product;

import java.util.ArrayList;
import java.util.Collection;
import java.util.ListIterator;

public class UniqueProductArrayList<E extends Product> extends ArrayList<E> {

    public UniqueProductArrayList() {
        super();
    }

    @Override
    public E set(int index, E element) {
        if (this.contains(element)) {
            return get(index);
        }
        return super.set(index, element);
    }

    @Override
    public boolean add(E e) {
        if (this.contains(e)) {
            return false;
        }
        return super.add(e);
    }

    @Override
    public void add(int index, E element) {
        if (this.contains(element)) {
            return;
        }
        super.add(index, element);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        boolean flag = false;
        for (E temp : c) {
            if (this.add(temp))
                flag = true;
        }
        return flag;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        for (E temp : c) {
            this.add(index++, temp);
        }
        return true;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator<E> listIterator() {
        throw new UnsupportedOperationException();
    }
}
