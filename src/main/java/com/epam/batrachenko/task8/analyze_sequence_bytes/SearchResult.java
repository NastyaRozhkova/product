package com.epam.batrachenko.task8.analyze_sequence_bytes;

import java.util.Objects;

public class SearchResult {
    private int maxLength = 0;
    private int firstIndex = -1;
    private int secondIndex = -1;

    public int getMaxLength() {
        return maxLength;
    }

    public void setMaxLength(int maxLength) {
        this.maxLength = maxLength;
    }

    public int getFirstIndex() {
        return firstIndex;
    }

    public void setFirstIndex(int firstIndex) {
        this.firstIndex = firstIndex;
    }

    public int getSecondIndex() {
        return secondIndex;
    }

    public void setSecondIndex(int secondIndex) {
        this.secondIndex = secondIndex;
    }

    public SearchResult(int maxLength, int firstIndex, int secondIndex) {
        this.maxLength = maxLength;
        this.firstIndex = firstIndex;
        this.secondIndex = secondIndex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SearchResult that = (SearchResult) o;
        return maxLength == that.maxLength && firstIndex == that.firstIndex && secondIndex == that.secondIndex;
    }

    @Override
    public int hashCode() {
        return Objects.hash(maxLength, firstIndex, secondIndex);
    }
}
