package com.epam.batrachenko.task8.searching_primes.creators;

import com.epam.batrachenko.task8.searching_primes.FindPrimes;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SearchExecutorGeneralCollectionRunnableCreator implements SearchRunnableCreator {

    @Override
    public Runnable createSearch(Map.Entry<Integer, Integer> subInterval, List<Integer> primes) {
        return () -> {
            ExecutorService executor = Executors.newSingleThreadExecutor();
            executor.submit(() -> new FindPrimes().checkPrimes(subInterval, primes));
        };
    }
}
