package com.epam.batrachenko.task8.searching_primes;

import com.epam.batrachenko.task7.reflection.InputOutputData;
import com.epam.batrachenko.task8.searching_primes.creators.SearchContainer;
import com.epam.batrachenko.task8.searching_primes.creators.SearchCreator;
import com.epam.batrachenko.task8.searching_primes.launchers.Launchable;
import com.epam.batrachenko.task8.searching_primes.launchers.LauncherContainer;

import java.util.List;

public class SearchPrimeNumbersApp {

    private int left;
    private int right;
    private int countThreads;
    private InputOutputData inputOutputData;

    public SearchPrimeNumbersApp(InputOutputData inputOutputData) {
        this.inputOutputData = inputOutputData;
    }

    public List<Integer> searchPrimeNumbers() {
        inputData(inputOutputData);
        SearchPrimeNumbers searchPrimeNumbers = new SearchPrimeNumbers();
        Thread searching = new Thread(() ->
                inputOutputData.print(String.valueOf(searchPrimeNumbers.search(left, right, countThreads, chooseSearchType(), chooseLauncherType()))));
        searching.start();
        try {
            searching.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return searchPrimeNumbers.getPrimes();
    }

    private void inputData(InputOutputData inputOutputData) {
        left = Integer.parseInt(inputOutputData.getInput("Input left bound of interval of numbers"));
        right = Integer.parseInt(inputOutputData.getInput("Input right bound of interval of numbers"));
        countThreads = Integer.parseInt(inputOutputData.getInput("Input count of threads"));
    }

    private Launchable chooseLauncherType() {
        LauncherContainer launcherContainer = new LauncherContainer();
        Integer code = inputOutputData.inputCodeOfProductClass(launcherContainer.getSearches());
        return launcherContainer.getSearchCreatorByCode(code);
    }

    private SearchCreator chooseSearchType() {
        SearchContainer searchContainer = new SearchContainer();
        Integer code = inputOutputData.inputCodeOfProductClass(searchContainer.getSearches());
        return searchContainer.getSearchCreatorByCode(code);
    }
}
