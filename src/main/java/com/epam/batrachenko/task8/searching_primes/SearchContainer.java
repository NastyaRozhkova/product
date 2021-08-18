package com.epam.batrachenko.task8.searching_primes;

import com.epam.batrachenko.task8.searching_primes.creators.*;

import java.util.HashMap;
import java.util.Map;

public class SearchContainer {
    private final Map<Integer, SearchCreator> searches = new HashMap<>();

    public SearchContainer() {
        searches.put(1, new SearchThreadGeneralCollectionCreator());
        searches.put(2, new SearchThreadOwnCollectionCreator());
        searches.put(3, new SearchExecutorGeneralCollectionCreator());
        searches.put(4, new SearchExecutorOwnCollectionCreator());
    }

    public SearchCreator getSearchCreatorByCode(int code) {
        return searches.get(code);
    }

    public String getSearches() {
        StringBuilder sb = new StringBuilder();
        searches.forEach((k, v) -> sb.append(k).append("-").append(v.getClass().getSimpleName()).append(System.lineSeparator()));
        return sb.toString();
    }
}
