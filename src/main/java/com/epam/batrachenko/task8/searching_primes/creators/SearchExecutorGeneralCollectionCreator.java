package com.epam.batrachenko.task8.searching_primes.creators;

import com.epam.batrachenko.task8.searching_primes.SearchPrimeNumbers;

import java.util.AbstractMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SearchExecutorGeneralCollectionCreator implements SearchCreator {
    @Override
    public SearchPrimeNumbers createSearch(int left, int right, int countThreads) {
        return new SearchPrimeNumbers(left, right, countThreads) {
            @Override
            public Long searchPrimeNumbers() {
                long time = System.currentTimeMillis();
                for (int i = 0; i < countThreads; i++) {
                    AbstractMap.SimpleEntry<Integer, Integer> interval = getSubIntervalByNumber(i);
                    ExecutorService executor = Executors.newSingleThreadExecutor();
                    executor.submit(() -> {
                        for (int j = interval.getKey(); j <= interval.getValue(); j++) {
                            if (checkPrime(j)) {
                                primes.add(j);
                            }
                        }
                    });
                }
                return System.currentTimeMillis() - time;
            }
        };
    }
}
