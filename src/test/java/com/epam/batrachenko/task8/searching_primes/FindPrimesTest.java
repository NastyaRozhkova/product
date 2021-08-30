package com.epam.batrachenko.task8.searching_primes;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class FindPrimesTest {

    @Test
    public void shouldCorrectlyChekIsNumberPrime() {
        FindPrimes findPrimes = new FindPrimes();
        Assert.assertTrue(findPrimes.isPrime(1));
        Assert.assertTrue(findPrimes.isPrime(7));
        Assert.assertTrue(findPrimes.isPrime(19));
        Assert.assertFalse(findPrimes.isPrime(20));
    }

    @Test
    public void shouldCorrectlyFindPrimeNumbers() {
        FindPrimes findPrimes = new FindPrimes();
        List<Integer> actualPrimes = new ArrayList<>();
        Map.Entry<Integer, Integer> interval= new AbstractMap.SimpleEntry<>(1,20);
        findPrimes.checkPrimes(interval,actualPrimes);

        List<Integer> expectedPrimes = Arrays.stream(
                new Integer[]{1,2,3,5,7,11,13,17,19}).collect(Collectors.toList());

        Assert.assertEquals(expectedPrimes,actualPrimes);
    }
}