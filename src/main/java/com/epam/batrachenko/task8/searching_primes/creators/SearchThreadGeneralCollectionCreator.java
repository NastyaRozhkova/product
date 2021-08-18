package com.epam.batrachenko.task8.searching_primes.creators;

import com.epam.batrachenko.task8.searching_primes.SearchPrimeNumbers;

import java.util.AbstractMap;

public class SearchThreadGeneralCollectionCreator implements SearchCreator {

    @Override
    public SearchPrimeNumbers createSearch(int left, int right, int countThreads) {
        return new SearchPrimeNumbers(left, right, countThreads) {
            @Override
            public Long searchPrimeNumbers() {
                long time = System.currentTimeMillis();
                for (int i = 0; i < countThreads; i++) {
                    AbstractMap.SimpleEntry<Integer, Integer> interval = getSubIntervalByNumber(i);
                    new Thread(() -> {
                        for (int j = interval.getKey(); j <= interval.getValue(); j++) {
                            if (checkPrime(j)) {
                                primes.add(j);
                            }
                        }
                    },"searching").start();
                }
                return System.currentTimeMillis() - time;
            }
        };
    }
}