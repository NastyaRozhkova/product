package com.epam.batrachenko.task8.analyze_sequence_bytes;

import com.epam.batrachenko.task7.reflection.InputOutputData;

public class SearchSequenceOfBytesApp {
    public void searchLongestSequenceOfBytesInFiles(InputOutputData inputOutputData) {
        SearchService searchService = new SearchService();

        String line = inputOutputData.getInput("Input file name or exit to finish");
        while (!line.equals("exit")) {
            SearchResult searchResult = searchService.searchLongestSequenceOfBytesInFiles(line);
            line = inputOutputData.getInput("Result of searching" + System.lineSeparator() +
                    "maxLength " + searchResult.getMaxLength() + System.lineSeparator() +
                    "FirstIndex " + searchResult.getFirstIndex() + System.lineSeparator() +
                    "SecondIndex " + searchResult.getSecondIndex() + System.lineSeparator() + System.lineSeparator() +
                    "Input file name or exit to finish");
        }
        searchService.getSearchThread().interrupt();
    }

}
