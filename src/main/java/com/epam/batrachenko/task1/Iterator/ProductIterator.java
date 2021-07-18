package com.epam.batrachenko.task1.Iterator;

import com.epam.batrachenko.task1.Entity.Product;
import com.epam.batrachenko.task1.List.ProductContainer;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

    public class ProductIterator<E extends Product> implements Iterator<E> {
        private ProductContainer<E> productContainer;
        private int index;
        Predicate<E> logic;

        public ProductIterator(Predicate<E> logic,ProductContainer<E> products) {
            this.productContainer=products;
            this.index = 0;
            this.logic = logic;
        }

        public ProductIterator(ProductContainer<E> products) {
            this.productContainer=products;
            this.index = 0;
            this.logic = (E) -> true;
        }

        public boolean hasNext() {
            for (int temp = this.index; temp + 1 < productContainer.size(); ++temp) {
                if (this.logic.test((E) productContainer.toArray()[temp])) {
                    return true;
                }
            }

            return false;
        }

        public E next() {
            while (this.index + 1 < productContainer.size()) {
                if (this.logic.test(((E) productContainer.toArray()[index]))) {
                    return ((E) productContainer.toArray()[index]);
                }
                ++this.index;
            }
            throw new NoSuchElementException();
        }
    }
