package com.epam.batrachenko.task8.searching_primes.launchers;

public class ThreadLaunch implements Launchable {
    @Override
    public void launchInThread(Runnable action) {
        new Thread(action).start();
    }
}
