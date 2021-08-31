package com.epam.batrachenko.task8.searching_primes;

import com.epam.batrachenko.task8.searching_primes.creators.SearchCreator;
import com.epam.batrachenko.task8.searching_primes.launchers.Launchable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class SearchPrimeNumbers {

    protected List<Integer> primes = Collections.synchronizedList(new ArrayList<>());

    public List<Integer> getPrimes() {
        return primes;
    }

    public long search(int left, int right, int countThreads, SearchCreator searchCreator, Launchable launchable) {
        long time = System.currentTimeMillis();
        List<Map.Entry<Integer, Integer>> subIntervals = new IntervalUtil().splitInterval(left, right, countThreads);
        for (Map.Entry<Integer, Integer> subInterval : subIntervals) {
            launchable.launchInThread(searchCreator.createSearch(subInterval, primes));
        }
        return System.currentTimeMillis() - time;
    }
}
