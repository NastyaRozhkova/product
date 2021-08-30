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

    public SearchResult findMaxLengthAndIndexInSequence(){
        for (int i = fileText.length / 2; i > 0; i--) {
            result.add(String.valueOf(i));
            for (int j = 0; j <= fileText.length - 2 * i; j++) {
                int index = find(fileText, getByteArray(fileText, j, i), j);
                if (index != -1) {
                    return new SearchResult(i, j, index);
                }
            }
        }
        return new SearchResult();
    }

    private int find(byte[] fileText, byte[] example, int index) {
        for (int i = example.length + index; i <= fileText.length - example.length; i++) {
            byte[] segment = getByteArray(fileText, i, example.length);
            if (Arrays.equals(example, segment)) {
                return i;
            }
        }
        return -1;
    }

    private byte[] getByteArray(byte[] example, int index, int size) {
        if (size >= 0) {
            byte[] segment = new byte[size];
            System.arraycopy(example, index, segment, 0, size);
            return segment;
        }
        throw new IllegalArgumentException();
    }

}
