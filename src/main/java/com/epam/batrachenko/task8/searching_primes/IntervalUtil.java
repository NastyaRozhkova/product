package com.epam.batrachenko.task8.searching_primes;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class IntervalUtil {

    public List<Map.Entry<Integer, Integer>> splitInterval(int left, int right, int count) {
        List<Map.Entry<Integer, Integer>> ranges = new ArrayList<>();
        int length = (right - left + 1) / count;
        int countIncreasedIntervals = (right - left + 1) % count;
        int rightSub;

        for (int i = 0; i < count; i++) {
            rightSub = left + length;
            if (i >= countIncreasedIntervals)
                rightSub--;
            ranges.add(new AbstractMap.SimpleEntry<>(left, rightSub));
            left += rightSub - left + 1;
        }

        return ranges;
    }
}
