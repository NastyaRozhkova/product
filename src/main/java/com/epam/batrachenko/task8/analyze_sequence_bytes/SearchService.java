package com.epam.batrachenko.task8.analyze_sequence_bytes;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class SearchService {

    private static final Logger log = LoggerFactory.getLogger(SearchService.class);
    private final SearchSequenceOfBytes search;
    private final BlockingQueue<String> result = new ArrayBlockingQueue<>(1_000_000);
    private SearchResult searchResult;
    private volatile boolean isSearchFinished;

    public SearchResult searchLongestSequenceOfBytesInFiles(String fileName) {
        searchInFile(fileName);
        return searchResult;
    }

    public SearchService() {
        search = new SearchSequenceOfBytes(result);
        startSearchThread(search);
    }

    public void searchInFile(String file) {
        search.setFileText(FileReaderUtil.getFileText(file));
        isSearchFinished = false;
        synchronized (this) {
            this.notify();
        }
        while (!isSearchFinished) {
            while (!result.isEmpty()) {
                try {
                    System.out.println("current checked length " + result.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void startSearchThread(SearchSequenceOfBytes search) {
        Thread searchThread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    synchronized (this) {
                        this.wait();
                    }
                    isSearchFinished = false;
                    searchResult = search.findMaxLengthAndIndexInSequence();
                    isSearchFinished = true;
                } catch (InterruptedException e) {
                    log.debug(e.getMessage(), e);
                }
            }
        }, "searchThread");
        searchThread.setDaemon(true);
        searchThread.start();
    }
}
