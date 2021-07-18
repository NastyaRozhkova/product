package com.epam.batrachenko.task1.List;

import com.epam.batrachenko.task1.Entity.Product;
import com.epam.batrachenko.task1.Iterator.ProductIterator;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Predicate;

public class ProductContainer<E extends Product> implements List<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private E[] array;
    private int size;

    public ProductContainer() {
        this.array = (E[]) new Product[DEFAULT_CAPACITY];
        this.size = 0;
    }

    public ProductContainer(Class<E> dataType, int capacity) {
        this.array = (E[]) Array.newInstance(dataType, capacity);
        this.size = 0;
    }

    @Override
    public void clear() {
        this.array = (E[]) new Product[DEFAULT_CAPACITY];
        this.size = 0;
    }

    @Override
    public E get(int index) {
        if (index >= 0 && index < this.size) {
            return this.array[index];
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    @Override
    public E set(int index, E element) {
        if (index >= 0 && index < this.size) {
            this.array[index] = element;
            return this.array[index];
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    @Override
    public void add(int index, E element) {
        if (index >= 0 && index <= this.size) {
            if (this.array.length == this.size) {
                E[] newArray = (E[]) new Object[this.array.length * 2];
                System.arraycopy(this.array, 0, newArray, 0, index);
                System.arraycopy(this.array, index, newArray, index + 1, this.size - index);
                this.array = newArray;
            } else {
                System.arraycopy(this.array, index, this.array, index + 1, this.size - index);
            }

            this.array[index] = element;
            ++this.size;
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    @Override
    public E remove(int index) {
        if (index >= 0 && index < this.size) {
            E temp = this.array[index];
            System.arraycopy(this.array, index + 1, this.array, index, this.size - index);
            --this.size;
            return temp;
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < this.size; ++i) {
            if (this.array[i] == null) {
                if (o == null) {
                    return i;
                }
            } else if (this.array[i].equals(o)) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for (int i = this.size - 1; i >= 0; --i) {
            if (this.array[i] == null) {
                if (o == null) {
                    return i;
                }
            } else if (this.array[i].equals(o)) {
                return i;
            }
        }

        return -1;
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

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < this.size; ++i) {
            if (this.array[i] == null) {
                if (o == null) {
                    return true;
                }
            } else if (this.array[i].equals(o)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new ProductIterator<E>(this);
    }


    public Iterator<E> logicIterator(Predicate<E> predicate) {
        return new ProductIterator<E>(predicate,this);
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(this.array, this.size);
    }

    @Override
    public <T> T[] toArray(T[] a) {
        if (a.length < this.size) {
            return (T[]) Arrays.copyOf(this.array, this.size, a.getClass());
        } else {
            System.arraycopy(this.array, 0, a, 0, this.size);
            if (a.length > this.size) {
                a[this.size] = null;
            }

            return a;
        }
    }

    @Override
    public boolean add(E e) {
        if (this.size == this.array.length) {
            E[] newArray = (E[]) new Object[this.array.length * 2];
            System.arraycopy(this.array, 0, newArray, 0, this.size);
            newArray[this.size] = e;
            this.array = newArray;
        } else {
            this.array[this.size] = e;
        }

        ++this.size;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < this.size; ++i) {
            if (this.array[i] == null) {
                if (o == null) {
                    this.remove(i);
                    return true;
                }
            } else if (this.array[i].equals(o)) {
                this.remove(i);
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        if (c == null) {
            return false;
        }
        for (Object temp : c) {
            if (!contains(temp)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        if (c == null) {
            return false;
        }
        for (E temp : c) {
            add(temp);
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        if(c==null){
            return false;
        }
        for (E temp : c) {
            add(index, temp);
        }
        return true;
    }

    public boolean removeAll(Collection<?> c) {
        if(c==null){
            return false;
        }
        boolean flag=false;
        for (Object temp : c) {
            if(remove(temp)){
                flag=true;
            }
        }
        return flag;
    }

    public boolean retainAll(Collection<?> c) {
        if(c==null){
            return false;
        }
        boolean flag=false;
        for (Object temp : array) {
            if(!c.contains(temp)){
                if(remove(temp)){
                    flag=true;
                }
            }
        }
        return flag;
    }

    /*private class ProductIterator implements Iterator<E> {
        private int index;
        Predicate<E> logic;

        public ProductIterator(Predicate<E> logic) {
            this.index = 0;
            this.logic = logic;
        }

        public ProductIterator() {
            this.index = 0;
            this.logic = (E) -> true;
        }

        public boolean hasNext() {
            for (int temp = this.index; temp + 1 < size; ++temp) {
                if (this.logic.test(array[temp])) {
                    return true;
                }
            }

            return false;
        }

        public E next() {
            while (this.index + 1 < size) {
                if (this.logic.test(array[this.index])) {
                    return array[this.index];
                }
                ++this.index;
            }
            throw new NoSuchElementException();
        }
    }*/

}

