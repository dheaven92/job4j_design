package ru.job4j.collections.set;

import org.junit.Test;

import static org.junit.Assert.*;

public class SimpleSetTest {

    @Test
    public void whenAddNonNull() {
        Set<Integer> set = new SimpleSet<>();
        assertTrue(set.add(1));
        assertTrue(set.contains(1));
        assertFalse(set.add(1));
    }

    @Test
    public void whenAddNull() {
        Set<Integer> set = new SimpleSet<>();
        assertTrue(set.add(null));
        assertTrue(set.contains(null));
        assertFalse(set.add(null));
    }

    @Test
    public void whenAddUser() {
        Set<User> set = new SimpleSet<>();
        assertTrue(set.add(new User("Bob", 32)));
        assertTrue(set.contains(new User("Bob", 32)));
        assertTrue(set.add(new User("Bob", 33)));
        assertFalse(set.add(new User("Bob", 32)));
    }
}