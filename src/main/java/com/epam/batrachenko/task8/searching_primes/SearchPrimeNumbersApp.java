package com.epam.batrachenko.task8.searching_primes;

import com.epam.batrachenko.task7.reflection.InputOutputData;
import com.epam.batrachenko.task8.searching_primes.creators.SearchCreator;

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
        SearchPrimeNumbers search = chooseType();
        Thread searching = new Thread(()->
        inputOutputData.print(String.valueOf(search.searchPrimeNumbers())));
        searching.start();
        try {
            searching.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return search.getPrimes();
    }

    private void inputData(InputOutputData inputOutputData) {
        left = Integer.parseInt(inputOutputData.getInput("Input left bound of interval of numbers"));
        right = Integer.parseInt(inputOutputData.getInput("Input right bound of interval of numbers"));
        countThreads = Integer.parseInt(inputOutputData.getInput("Input count of threads"));
    }

    private SearchPrimeNumbers chooseType() {
        SearchContainer searchContainer = new SearchContainer();
        Integer code = inputOutputData.inputCodeOfProductClass(searchContainer.getSearches());
        SearchCreator creator = searchContainer.getSearchCreatorByCode(code);
        return creator.createSearch(left, right, countThreads);
    }
}
