package com.epam.batrachenko.task8.searching_primes.creators;

import com.epam.batrachenko.task8.searching_primes.FindPrimes;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SearchOwnCollectionCreator implements SearchCreator {

    public Runnable createSearch(Map.Entry<Integer, Integer> subInterval, List<Integer> primes) {
        return () ->
        {
            List<Integer> ownListPrimes = new ArrayList<>();
            new FindPrimes().checkPrimes(subInterval, ownListPrimes);
            primes.addAll(ownListPrimes);
        };
    }
}
