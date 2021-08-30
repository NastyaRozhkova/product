package com.epam.batrachenko.task8.searching_primes;

import com.epam.batrachenko.task8.searching_primes.creators.SearchRunnableCreator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SearchPrimeNumbers {

    protected List<Integer> primes = new ArrayList<>();

    public List<Integer> getPrimes() {
        return primes;
    }

    public long search(int left, int right, int countThreads, SearchRunnableCreator searchRunnableCreator) {
        long time = System.currentTimeMillis();
        List<Map.Entry<Integer, Integer>> subIntervals = new IntervalUtil().splitInterval(left, right, countThreads);
        for (Map.Entry<Integer, Integer> subInterval : subIntervals) {
            searchRunnableCreator.createSearch(subInterval, primes).run();
        }
        return System.currentTimeMillis() - time;
    }
}
