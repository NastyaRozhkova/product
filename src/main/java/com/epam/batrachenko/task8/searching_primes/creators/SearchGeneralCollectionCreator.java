package com.epam.batrachenko.task8.searching_primes.creators;

import com.epam.batrachenko.task8.searching_primes.FindPrimes;

import java.util.List;
import java.util.Map;

public class SearchGeneralCollectionCreator implements SearchCreator {

    @Override
    public Runnable createSearch(Map.Entry<Integer, Integer> subInterval, List<Integer> primes) {
        return () -> new FindPrimes().checkPrimes(subInterval, primes);
    }
}
