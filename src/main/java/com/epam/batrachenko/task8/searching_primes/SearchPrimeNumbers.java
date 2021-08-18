package com.epam.batrachenko.task8.searching_primes;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;

public abstract class SearchPrimeNumbers {
    protected int left;
    protected int right;
    protected int countThreads;
    protected List<Integer> primes = new ArrayList<>();

    public List<Integer> getPrimes() {
        return primes;
    }

    protected SearchPrimeNumbers(int left, int right, int countThreads) {
        this.left = left;
        this.right = right;
        this.countThreads = countThreads;
    }

    public abstract Long searchPrimeNumbers();

    protected boolean checkPrime(int number) {
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    protected AbstractMap.SimpleEntry<Integer, Integer> getSubIntervalByNumber(int number) {
        int length = (right - left + 1) / countThreads;
        int countIncreasedIntervals = (right - left + 1) % countThreads;

        int leftSub = left+(length + 1) * (Math.min(number, countIncreasedIntervals)) +
                length * (number > countIncreasedIntervals ? (number - countIncreasedIntervals) : 0);
        int rightSub = leftSub + length-1 + (number >= countIncreasedIntervals ? 0 : 1);

        return new AbstractMap.SimpleEntry<>(leftSub, rightSub);
    }
}
