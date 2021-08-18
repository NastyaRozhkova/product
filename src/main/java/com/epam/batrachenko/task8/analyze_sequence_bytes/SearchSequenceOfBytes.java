package com.epam.batrachenko.task8.analyze_sequence_bytes;

import java.util.Arrays;
import java.util.concurrent.BlockingQueue;

public class SearchSequenceOfBytes {
    private byte[] fileText;
    private final BlockingQueue<String> result;

    public SearchSequenceOfBytes(BlockingQueue<String> result) {
        this.result = result;
    }

    public void setFileText(byte[] fileText) {
        this.fileText = fileText;
    }

    public SearchResult findMaxLengthAndIndexInSequence() throws InterruptedException {
        for (int i = fileText.length / 2; i > 0; i--) {
            result.add(String.valueOf(i));
            for (int j = 0; j <= fileText.length - 2 * i; j++) {
                int index = find(fileText, getByteArray(fileText, j, i), j);
                if (index != -1) {
                    return new SearchResult(i, j, index);
                }
            }
        }
        return new SearchResult(0, -1, -1);
    }

    private int find(byte[] fileText, byte[] segment, int index) {
        for (int i = segment.length + index; i <= fileText.length - segment.length; i++) {
            byte[] segment2 = getByteArray(fileText, i, segment.length);
            if (Arrays.equals(segment, segment2)) {
                return i;
            }
        }
        return -1;
    }

    private byte[] getByteArray(byte[] fileText, int index, int size) {
        if (size >= 0) {
            byte[] segment2 = new byte[size];
            System.arraycopy(fileText, index, segment2, 0, size);
            return segment2;
        }
        throw new IllegalArgumentException();
    }

}
