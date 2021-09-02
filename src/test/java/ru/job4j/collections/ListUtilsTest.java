package ru.job4j.collections;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class ListUtilsTest {

    @Test
    public void whenAddBefore() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 1, 2);
        assertThat(input, is(List.of(1, 2, 3)));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenAddBeforeWithInvalidIndex() {
        List<Integer> input = new ArrayList<>(List.of(1, 3));
        ListUtils.addBefore(input, 3, 2);
    }

    @Test
    public void whenAddAfterLast() {
        List<Integer> input = new ArrayList<>(List.of(0, 1, 2));
        ListUtils.addAfter(input, 2, 3);
        assertThat(input, is(List.of(0, 1, 2, 3)));
    }

    @Test
    public void whenRemoveIf() {
        List<Integer> input = new ArrayList<>(List.of(1, 2, 4, -1));
        ListUtils.removeIf(input, i -> i % 2 == 0);
        assertThat(input, is(List.of(1, -1)));
    }

    @Test
    public void whenReplaceIf() {
        List<String> input = new ArrayList<>(List.of("acer", "lenovo", "asus", "apple"));
        ListUtils.replaceIf(input, i -> i.startsWith("a"), "thinkpad");
        assertThat(input, is(List.of("thinkpad", "lenovo", "thinkpad", "thinkpad")));
    }

    @Test
    public void whenRemoveAll() {
        List<Integer> input = new ArrayList<>(List.of(2, 11, 42, 0));
        ListUtils.removeAll(input, List.of(2, 11, 42));
        assertThat(input, is(List.of(0)));
    }
}