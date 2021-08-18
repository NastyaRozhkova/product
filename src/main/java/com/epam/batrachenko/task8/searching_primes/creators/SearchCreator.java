package com.epam.batrachenko.task8.searching_primes.creators;

import com.epam.batrachenko.task8.searching_primes.SearchPrimeNumbers;

public interface SearchCreator {
    SearchPrimeNumbers createSearch(int left, int right, int countThreads);
}
