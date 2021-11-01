package ru.job4j.ood.tdd.template;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Map;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class GeneratorTest {

    private Generator generator;

    @Before
    public void init() {
        generator = new TemplateGenerator();
    }

    @Ignore
    @Test
    public void whenValidTemplateAndMap() {
        String template = "Hi! My name is ${name}";
        Map<String, String> map = Map.of("name", "Bob");
        assertThat(generator.produce(template, map), is("Hi! My name is Bob"));
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void whenNotEnoughKeys() {
        String template = "Hi! My name is ${name} and I'm ${age}";
        Map<String, String> map = Map.of("name", "Bob");
        generator.produce(template, map);
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void whenTooManyKeys() {
        String template = "Hi! My name is ${name}";
        Map<String, String> map = Map.of("name", "Bob", "age", "32");
        generator.produce(template, map);
    }
}