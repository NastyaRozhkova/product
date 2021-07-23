package com.epam.batrachenko.task2.List;

import com.epam.batrachenko.task1.Entity.Product;
import com.epam.batrachenko.task1.List.ProductArrayList;
import com.epam.batrachenko.task2.Iterator.UnmodifiableModifiableProductListIterator;

import java.util.*;

/**
 * List, that consists of two lists: unmodifiable and modifiable.
 * Unmodifiable list unsupported any method that change data.
 * Modifiable list supported all methods of list.
 *
 * @author Vladyslav Batrachenko
 * @see Product, UnmodifiableProductList, ProductArrayList, List
 */
public class UnmodifiableModifiableProductList<E extends Product> implements List<E> {
    private final UnmodifiableProductList<E> unmodifiableProductList;
    private final ProductArrayList<E> modifiableProductList;

    public UnmodifiableModifiableProductList(ProductArrayList<E> unmodifiableProductList, ProductArrayList<E> modifiableProductList) {
        this.unmodifiableProductList = new UnmodifiableProductList<>(unmodifiableProductList);
        this.modifiableProductList = modifiableProductList;
    }

    public ProductArrayList<E> getList() {
        ProductArrayList<E> arrayList = new ProductArrayList<>();
        arrayList.addAll(unmodifiableProductList);
        arrayList.addAll(modifiableProductList);
        return arrayList;
    }

    @Override
    public int size() {
        return unmodifiableProductList.size() + modifiableProductList.size();
    }

    @Override
    public boolean isEmpty() {
        return unmodifiableProductList.isEmpty() && modifiableProductList.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return unmodifiableProductList.contains(o) || modifiableProductList.contains(o);
    }

    @Override
    public Iterator<E> iterator() {
        return new UnmodifiableModifiableProductListIterator<>(this);
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[this.size()];
        System.arraycopy(unmodifiableProductList.toArray(), 0, array, 0, unmodifiableProductList.size());
        System.arraycopy(modifiableProductList.toArray(), 0, array, unmodifiableProductList.size(), modifiableProductList.size());
        return array;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return (T[]) Arrays.copyOf(this.toArray(), this.size(), a.getClass());
    }

    @Override
    public boolean add(E e) {
        return modifiableProductList.add(e);
    }

    @Override
    public boolean remove(Object o) {
        if (unmodifiableProductList.contains(o)) {
            throw new UnsupportedOperationException();
        }
        return modifiableProductList.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        if (c == null) {
            throw new NullPointerException();
        }
        for (Object temp : c) {
            if (!unmodifiableProductList.contains(temp) && !modifiableProductList.contains(temp)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return modifiableProductList.addAll(c);
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        checkIndexInUnmodifiableList(index);
        return modifiableProductList.addAll(index - unmodifiableProductList.size(), c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return modifiableProductList.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return modifiableProductList.retainAll(c);
    }

    @Override
    public void clear() {
        modifiableProductList.clear();
    }

    @Override
    public E get(int index) {
        if (index < unmodifiableProductList.size()) {
            return unmodifiableProductList.get(index);
        } else {
            return modifiableProductList.get(index - unmodifiableProductList.size());
        }
    }

    @Override
    public E set(int index, E element) {
        checkIndexInUnmodifiableList(index);
        return modifiableProductList.set(index - unmodifiableProductList.size(), element);
    }

    @Override
    public void add(int index, E element) {
        checkIndexInUnmodifiableList(index);
        modifiableProductList.add(index - unmodifiableProductList.size(), element);
    }

    @Override
    public E remove(int index) {
        checkIndexInUnmodifiableList(index);
        return modifiableProductList.remove(index - unmodifiableProductList.size());
    }

    @Override
    public int indexOf(Object o) {
        int index = unmodifiableProductList.indexOf(o);
        if (index == -1) {
            return modifiableProductList.indexOf(o) + unmodifiableProductList.size();
        } else {
            return index;
        }
    }

    @Override
    public int lastIndexOf(Object o) {
        int index = modifiableProductList.lastIndexOf(o);
        if (index == -1) {
            return unmodifiableProductList.lastIndexOf(o);
        } else {
            return index + unmodifiableProductList.size();
        }
    }

    private void checkIndexInUnmodifiableList(int index) {
        if (index < 0 || index > this.size()) {
            throw new IndexOutOfBoundsException();
        } else if (unmodifiableProductList.size() > 0 && index >= 0 && index < unmodifiableProductList.size()){
            throw new UnsupportedOperationException("Unmodifiable part of list");
        }
    }

    @Override
    public ListIterator<E> listIterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }
}
