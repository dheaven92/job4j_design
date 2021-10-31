package ru.job4j.ood.tdd;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class MaxMinTest {

    private MaxMin maxMin;

    @Before
    public void init() {
        maxMin = new MaxMin();
    }

    @Test
    public void whenMin() {
        assertEquals(
                Integer.valueOf(1),
                maxMin.min(new ArrayList<>(List.of(4, 1, 10, 77)), Integer::compareTo)
        );
        assertEquals(
                "animal",
                maxMin.min(
                        new ArrayList<>(List.of("bird", "pig", "animal", "armadillo")),
                        String::compareTo
                )
        );
        assertEquals(
                "Dog",
                maxMin.min(
                        new ArrayList<>(List.of("Kitty", "Rabbit", "Dog", "Cat")),
                        Comparator.comparingInt(String::length)
                )
        );
    }

    @Test
    public void whenMax() {
        assertEquals(
                Integer.valueOf(1),
                maxMin.max(new ArrayList<>(List.of(-21, 0, 0, -99, 1)), Integer::compareTo)
        );
        assertEquals(
                "Yellow rabbit",
                maxMin.max(
                        new ArrayList<>(List.of("Silicon fish", "Yellow rabbit", "Pink dog")),
                        String::compareTo
                )
        );
        assertNull(maxMin.max(null, Integer::compareTo));
        assertNull(maxMin.max(new ArrayList<>(), Integer::compareTo));
    }
}