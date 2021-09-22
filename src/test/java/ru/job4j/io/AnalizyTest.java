package ru.job4j.io;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.*;

import static org.junit.Assert.*;

public class AnalizyTest {

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void unavailableWhenTwoIntervals() throws IOException {
        File source = folder.newFile("source.log");
        File target = folder.newFile("target.csv");
        try (PrintWriter out = new PrintWriter(source)) {
            out.println("200 10:56:01");
            out.println("500 10:57:01");
            out.println("400 10:58:01");
            out.println("200 10:59:01");
            out.println("500 11:01:02");
            out.println("200 11:02:02");
        }
        new Analizy().unavailable(source.getAbsolutePath(), target.getAbsolutePath());
        StringBuilder actual = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new FileReader(target))) {
            in.lines().forEach(line -> actual.append(line).append(System.lineSeparator()));
        }
        String expected = "10:57:01;10:59:01;"
                + System.lineSeparator()
                + "11:01:02;11:02:02;"
                + System.lineSeparator();
        assertEquals(expected, actual.toString());
    }

    @Test
    public void unavailableWhenOneInterval() throws IOException {
        File source = folder.newFile("source.log");
        File target = folder.newFile("target.csv");
        try (PrintWriter out = new PrintWriter(source)) {
            out.println("200 10:56:01");
            out.println("500 10:57:01");
            out.println("400 10:58:01");
            out.println("500 10:59:01");
            out.println("400 11:01:02");
            out.println("200 11:02:02");
        }
        new Analizy().unavailable(source.getAbsolutePath(), target.getAbsolutePath());
        StringBuilder actual = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new FileReader(target))) {
            in.lines().forEach(line -> actual.append(line).append(System.lineSeparator()));
        }
        String expected = "10:57:01;11:02:02;" + System.lineSeparator();
        assertEquals(expected, actual.toString());
    }
}