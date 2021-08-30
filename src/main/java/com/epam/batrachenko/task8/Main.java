package com.epam.batrachenko.task8;

import com.epam.batrachenko.task7.reflection.InputOutputData;
import com.epam.batrachenko.task8.analyze_sequence_bytes.SearchSequenceOfBytesApp;
import com.epam.batrachenko.task8.searching_primes.SearchPrimeNumbersApp;

public class Main {

    public static void main(String... args) {
        new SearchPrimeNumbersApp(new InputOutputData()).searchPrimeNumbers();
        new SearchSequenceOfBytesApp().searchLongestSequenceOfBytesInFiles(new InputOutputData());
    }
}
