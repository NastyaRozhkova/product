package com.epam.batrachenko.task8.searching_primes;

import java.util.List;
import java.util.Map;

public class FindPrimes {

    public void checkPrimes(Map.Entry<Integer, Integer> interval, List<Integer> primes) {
        for (int j = interval.getKey(); j <= interval.getValue(); j++) {
            if (isPrime(j)) {
                primes.add(j);
            }
        }
    }

    public boolean isPrime(int number) {
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
