package ru.job4j.ood.lsp.car;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TruckTest {

    @Test
    public void whenValidSize() {
        assertEquals(2, new Truck(2).getSize());
        assertEquals(4, new Truck(4).getSize());
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenInvalidSize() {
        new Truck(0);
        new Truck(1);
        new Truck(-1);
    }
}