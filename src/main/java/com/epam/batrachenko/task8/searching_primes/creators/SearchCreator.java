package com.epam.batrachenko.task8.searching_primes.creators;

import java.util.List;
import java.util.Map;

public interface SearchCreator {
    Runnable createSearch(Map.Entry<Integer, Integer> subInterval, List<Integer> primes);
}
