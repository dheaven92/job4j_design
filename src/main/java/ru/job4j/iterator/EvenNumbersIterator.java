package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenNumbersIterator implements Iterator<Integer> {

    private int[] data;
    private int index;

    public EvenNumbersIterator(int[] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        if (index < data.length) {
            int nextIndex = index == data.length - 1 ? index : index + 1;
            return nextIndex < data.length && isEven(nextIndex);
        }
        return false;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        if (!isEven(index)) {
            index++;
        }
        return data[index++];
    }

    private boolean isEven(int index) {
        return data[index] % 2 == 0;
    }
}
