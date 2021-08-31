package com.epam.batrachenko.task8.searching_primes.launchers;

import java.util.HashMap;
import java.util.Map;

public class LauncherContainer {
    private final Map<Integer, Launchable> searches = new HashMap<>();

    public LauncherContainer() {
        searches.put(1, new ExecutorLaunch());
        searches.put(2, new ThreadLaunch());
    }

    public Launchable getSearchCreatorByCode(int code) {
        return searches.get(code);
    }

    public String getSearches() {
        StringBuilder sb = new StringBuilder();
        searches.forEach((k, v) -> sb.append(k).append("-").append(v.getClass().getSimpleName()).append(System.lineSeparator()));
        return sb.toString();
    }
}
