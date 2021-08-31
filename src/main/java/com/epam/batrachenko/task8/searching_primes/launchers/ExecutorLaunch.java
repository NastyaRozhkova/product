package com.epam.batrachenko.task8.searching_primes.launchers;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorLaunch implements Launchable {
    @Override
    public void launchInThread(Runnable action) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(action);
    }
}
