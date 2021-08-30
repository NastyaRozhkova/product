package com.epam.batrachenko.task8.searching_primes;

import org.junit.Assert;
import org.junit.Test;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class IntervalUtilTest {
    @Test
    public void shouldCorrectlySplitIntervalToThreeSubInterval(){
        List<Map.Entry<Integer, Integer>> actual = new IntervalUtil().splitInterval(1,20,3);
        List<Map.Entry<Integer, Integer>> expected = new ArrayList<>();
        expected.add(new AbstractMap.SimpleEntry<>(1, 7));
        expected.add(new AbstractMap.SimpleEntry<>(8, 14));
        expected.add(new AbstractMap.SimpleEntry<>(15, 20));

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void shouldCorrectlySplitIntervalToFiveSubInterval(){
        List<Map.Entry<Integer, Integer>> actual = new IntervalUtil().splitInterval(1,20,5);
        List<Map.Entry<Integer, Integer>> expected = new ArrayList<>();
        expected.add(new AbstractMap.SimpleEntry<>(1, 4));
        expected.add(new AbstractMap.SimpleEntry<>(5, 8));
        expected.add(new AbstractMap.SimpleEntry<>(9, 12));
        expected.add(new AbstractMap.SimpleEntry<>(13, 16));
        expected.add(new AbstractMap.SimpleEntry<>(17, 20));

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void shouldCorrectlySplitIntervalToOneSubInterval(){
        List<Map.Entry<Integer, Integer>> actual = new IntervalUtil().splitInterval(5,100,1);
        List<Map.Entry<Integer, Integer>> expected = new ArrayList<>();
        expected.add(new AbstractMap.SimpleEntry<>(5, 100));

        Assert.assertEquals(expected,actual);
    }
}