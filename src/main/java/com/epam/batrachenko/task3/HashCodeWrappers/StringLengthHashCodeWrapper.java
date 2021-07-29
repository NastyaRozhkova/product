package com.epam.batrachenko.task3.HashCodeWrappers;

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
