package ru.job4j.ood.lsp.car;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class PassengerTest {

    @Ignore
    @Test
    public void whenValidSize() {
        assertEquals(1, new Passenger(1).getSize());
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void whenInvalidSize() {
        new Passenger(0);
        new Passenger(2);
        new Passenger(-1);
    }
}