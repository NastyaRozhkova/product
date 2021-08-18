package com.epam.batrachenko.task8.analyze_sequence_bytes;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class SearchService {
    private final SearchSequenceOfBytes search;
    private final BlockingQueue<String> result = new ArrayBlockingQueue<>(1_000_000);
    private SearchResult searchResult;
    private volatile boolean isSearchingFinish;
    private Thread searchThread;

    public Thread getSearchThread() {
        return searchThread;
    }

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
        isSearchingFinish = false;
        synchronized (SearchService.class) {
            SearchService.class.notify();
        }
        while (!isSearchingFinish) {
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
        searchThread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    synchronized (SearchService.class) {
                        SearchService.class.wait();
                    }
                    isSearchingFinish = false;
                    searchResult = search.findMaxLengthAndIndexInSequence();
                    isSearchingFinish = true;
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }, "searchThread");
        searchThread.start();
    }
}
