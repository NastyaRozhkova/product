package com.epam.batrachenko.task8.searching_primes.creators;

import com.epam.batrachenko.task8.searching_primes.FindPrimes;

import java.util.List;
import java.util.Map;

public class SearchThreadGeneralCollectionRunnableCreator implements SearchRunnableCreator {

    @Override
    public Runnable createSearch(Map.Entry<Integer, Integer> subInterval, List<Integer> primes) {
        return new Thread(() -> new FindPrimes().checkPrimes(subInterval, primes), "searching");
    }
}