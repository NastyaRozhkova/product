package com.epam.batrachenko.task8.searching_primes.creators;

import com.epam.batrachenko.task8.searching_primes.FindPrimes;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SearchExecutorOwnCollectionRunnableCreator implements SearchRunnableCreator {

    public Runnable createSearch(Map.Entry<Integer, Integer> subInterval, List<Integer> primes) {
        return () -> {
            ExecutorService executor = Executors.newSingleThreadExecutor();
            executor.submit(() ->
            {
                List<Integer> ownListPrimes = new ArrayList<>();
                new FindPrimes().checkPrimes(subInterval, ownListPrimes);
                primes.addAll(ownListPrimes);
            });
        };
    }
}
