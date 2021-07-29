package com.epam.batrachenko.task3.List;

import com.epam.batrachenko.task1.Entity.Product;

import java.util.ArrayList;
import java.util.Collection;
import java.util.ListIterator;

/**
 * List witch extends ArrayList and store unique objects.
 * Object is unique if in collection there is not objects that equal it.
 * Methods which add object or change by index, check on contains objects equals it in collection,
 * and if method "contain" return false, they are performed.
 *
 * @author Vladyslav Batrachenko
 * @see Product , ArrayList
 */
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
