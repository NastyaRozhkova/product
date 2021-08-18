package com.epam.batrachenko.task8.searching_primes;

import com.epam.batrachenko.task7.reflection.InputOutputData;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;

public class SearchPrimeNumbersAppTest {

    @Test
    public void shouldFindAllPrimeNumbersBySearchExecutorGeneralCollection() {
        String data = "3" + System.lineSeparator() +
                "10" + System.lineSeparator() +
                "4" + System.lineSeparator() +
                "3" + System.lineSeparator();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(data.getBytes());

        SearchPrimeNumbersApp app = new SearchPrimeNumbersApp(new InputOutputData(inputStream));
        Integer[] actual = app.searchPrimeNumbers().stream().sorted().toArray(Integer[]::new);
        Integer[] expected = new Integer[]{3, 5, 7};
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindAllPrimeNumbersBySearchExecutorOwnCollection() {
        String data = "1" + System.lineSeparator() +
                "20" + System.lineSeparator() +
                "3" + System.lineSeparator() +
                "4" + System.lineSeparator();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(data.getBytes());

        SearchPrimeNumbersApp app = new SearchPrimeNumbersApp(new InputOutputData(inputStream));
        Integer[] actual = app.searchPrimeNumbers().stream().sorted().toArray(Integer[]::new);
        Integer[] expected = new Integer[]{1, 2, 3, 5, 7, 11, 13, 17, 19};
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindAllPrimeNumbersBySearchThreadGeneralCollection() {
        String data = "30" + System.lineSeparator() +
                "50" + System.lineSeparator() +
                "2" + System.lineSeparator() +
                "1" + System.lineSeparator();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(data.getBytes());

        SearchPrimeNumbersApp app = new SearchPrimeNumbersApp(new InputOutputData(inputStream));
        Integer[] actual = app.searchPrimeNumbers().stream().sorted().toArray(Integer[]::new);
        Integer[] expected = new Integer[]{31, 37, 41, 43, 47};
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindAllPrimeNumbersBySearchThreadOwnCollection() {
        String data = "60" + System.lineSeparator() +
                "69" + System.lineSeparator() +
                "5" + System.lineSeparator() +
                "2" + System.lineSeparator();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(data.getBytes());

        SearchPrimeNumbersApp app = new SearchPrimeNumbersApp(new InputOutputData(inputStream));
        Integer[] actual = app.searchPrimeNumbers().stream().sorted().toArray(Integer[]::new);
        Integer[] expected = new Integer[]{61, 67};
        Assert.assertArrayEquals(expected, actual);
    }
}