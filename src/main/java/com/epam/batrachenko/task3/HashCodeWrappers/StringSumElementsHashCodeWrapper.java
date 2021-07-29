package com.epam.batrachenko.task3.HashCodeWrappers;

/**
 * String Wrapper which override hashCode.
 * HashCode computed by sum of first four chars of string.
 * If length of string is less than four elements, sum all elements.
 *
 * @author Vladyslav Batrachenko
 */
public class StringSumElementsHashCodeWrapper {
    private final String name;

    public StringSumElementsHashCodeWrapper(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int sum = 0;
        for (int i = 0; i < Math.min(name.length(), 4); i++) {
            sum += name.charAt(i);
        }
        return sum;
    }
}
