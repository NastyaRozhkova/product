package com.epam.batrachenko.task8.analyze_sequence_bytes;

import org.junit.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import static org.junit.Assert.assertEquals;

public class SearchSequenceOfBytesTest {

    @Test
    public void shouldFindRepeatSequenceInByteArray() throws InterruptedException {
        byte[] data = new byte[]{1, 1, 2, 2, 5, 2, 1, 5, 1, 1, 2, 2};
        BlockingQueue<String> result = new ArrayBlockingQueue<>(1_000_000);

        SearchSequenceOfBytes search = new SearchSequenceOfBytes(result);
        search.setFileText(data);
        SearchResult actual = search.findMaxLengthAndIndexInSequence();
        SearchResult expected = new SearchResult(4, 0, 8);

        assertEquals(expected, actual);
    }
}