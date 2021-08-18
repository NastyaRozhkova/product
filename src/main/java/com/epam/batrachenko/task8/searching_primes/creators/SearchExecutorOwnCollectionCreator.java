package com.epam.batrachenko.task8.searching_primes.creators;

import com.epam.batrachenko.task8.searching_primes.SearchPrimeNumbers;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SearchExecutorOwnCollectionCreator implements SearchCreator{

    @Override
    public SearchPrimeNumbers createSearch(int left, int right, int countThreads) {
        return new SearchPrimeNumbers(left,right,countThreads) {
            @Override
            public Long searchPrimeNumbers() {
                long time = System.currentTimeMillis();
                for (int i = 0; i < countThreads; i++) {
                    AbstractMap.SimpleEntry<Integer, Integer> interval = getSubIntervalByNumber(i);
                    ExecutorService executor = Executors.newSingleThreadExecutor();
                    executor.submit(() -> {
                        List<Integer> ownListPrimes = new ArrayList<>();
                        for (int j = interval.getKey(); j <= interval.getValue(); j++) {
                            if (checkPrime(j)) {
                                ownListPrimes.add(j);
                            }
                        }
                        primes.addAll(ownListPrimes);
                    });
                }
                return System.currentTimeMillis() - time;
            }
        };
    }
}
