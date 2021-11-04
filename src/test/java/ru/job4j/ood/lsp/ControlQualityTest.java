package ru.job4j.ood.lsp;

import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

public class ControlQualityTest {

    @Test
    public void control() {
        List<Food> foods = List.of(
                new Food(
                        "cake",
                        LocalDate.of(2021, 11, 1),
                        LocalDate.of(2021, 11, 3),
                        99
                ),
                new Food(
                        "milk",
                        LocalDate.of(2021, 11, 2),
                        LocalDate.of(2021, 11, 7),
                        90
                ),
                new Food(
                        "bread",
                        LocalDate.of(2021, 11, 4),
                        LocalDate.of(2021, 11, 7),
                        60
                ),
                new Food(
                        "meat can",
                        LocalDate.of(2021, 4, 30),
                        LocalDate.of(2023, 4, 30),
                        300
                )
        );
        Store shop = new Shop();
        Store warehouse = new Warehouse();
        Store trash = new Trash();
        ControlQuality controller = new ControlQuality();
        foods.forEach(controller::control);
        assertEquals(1, warehouse.getAllFood().size());
        assertEquals(2, shop.getAllFood().size());
        assertEquals(1, trash.getAllFood().size());
    }
}