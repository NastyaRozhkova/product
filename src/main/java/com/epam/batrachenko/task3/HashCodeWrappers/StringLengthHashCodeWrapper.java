package com.epam.batrachenko.task3.HashCodeWrappers;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StringLengthHashCodeWrapper that = (StringLengthHashCodeWrapper) o;
        return Objects.equals(name, that.name);
    }
}
