package ru.job4j.collections.map;

import org.junit.Test;
import ru.job4j.collections.map.mymap.Map;
import ru.job4j.collections.map.mymap.SimpleMap;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.stream.IntStream;

import static org.junit.Assert.*;

public class SimpleMapTest {

    @Test
    public void whenAddFirstEntryToEmptyMap() {
        Map<String, Integer> map = new SimpleMap<>();
        assertTrue(map.put("a", 1));
    }

    @Test
    public void whenAddDuplicateEntry() {
        Map<String, Integer> map = new SimpleMap<>();
        map.put("a", 1);
        assertFalse(map.put("a", 11));
    }

    @Test
    public void whenAddMoreThenDefaultCapacityEntries() {
        Map<Integer, Integer> map = new SimpleMap<>();
        IntStream.range(1, 9)
                .forEach(i -> map.put(i, i * i));
        assertTrue(map.put(10, 100));
        assertEquals(Integer.valueOf(100), map.get(10));
    }

    @Test
    public void whenAddMoreThenDefaultCapacityEntriesThenAddDuplicate() {
        Map<Integer, Integer> map = new SimpleMap<>();
        map.put(10, 10);
        IntStream.range(1, 9)
                .forEach(i -> map.put(i, i * i));
        assertFalse(map.put(10, 100));
        assertEquals(Integer.valueOf(10), map.get(10));
    }

    @Test
    public void whenAdd2EntriesGet2Entries() {
        Map<String, Integer> map = new SimpleMap<>();
        map.put("a", 1);
        map.put("b", 2);
        assertEquals(Integer.valueOf(1), map.get("a"));
        assertEquals(Integer.valueOf(2), map.get("b"));
    }

    @Test
    public void whenAdd2EntriesGet3rdEntryNull() {
        Map<String, Integer> map = new SimpleMap<>();
        map.put("a", 1);
        map.put("b", 2);
        assertNull(map.get("c"));
    }

    @Test
    public void whenAddEntryThenRemoveEntry() {
        Map<String, Integer> map = new SimpleMap<>();
        map.put("a", 1);
        assertTrue(map.remove("a"));
        assertNull(map.get("a"));
    }

    @Test
    public void whenRemoveFromEmptyMap() {
        Map<String, Integer> map = new SimpleMap<>();
        assertFalse(map.remove("a"));
    }

    @Test
    public void whenAddThenRemoveThenIterate() {
        Map<String, Integer> map = new SimpleMap<>();
        map.put("a", 1);
        map.put("b", 2);
        map.remove("a");
        Iterator<String> iterator = map.iterator();
        assertEquals("b", iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test
    public void whenGetIteratorMultipleTimes() {
        Map<String, Integer> map = new SimpleMap<>();
        map.put("a", 1);
        map.put("b", 2);
        Iterator<String> iterator = map.iterator();
        assertTrue(iterator.hasNext());
        assertEquals("a", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("b", iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test(expected = NoSuchElementException.class)
    public void whenGetIteratorFromEmptyMapThenNextThrowException() {
        Map<String, Integer> map = new SimpleMap<>();
        map.iterator().next();
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenAddAfterGetIteratorThenMustBeException() {
        Map<String, Integer> map = new SimpleMap<>();
        Iterator<String> iterator = map.iterator();
        map.put("a", 1);
        iterator.next();
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenRemoveAfterGetIteratorThenMustBeException() {
        Map<String, Integer> map = new SimpleMap<>();
        map.put("a", 1);
        Iterator<String> iterator = map.iterator();
        map.remove("a");
        iterator.next();
    }
}