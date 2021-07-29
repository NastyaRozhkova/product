package com.epam.batrachenko.task3.HashCodeWrappers;

/**
 * String Wrapper which override hashCode.
 * HashCode computed by string length.
 *
 * @author Vladyslav Batrachenko
 */
public class StringLengthHashCodeWrapper {
    private final String name;

    public StringLengthHashCodeWrapper(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return name.length();
    }
}
