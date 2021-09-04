package ru.job4j.collections.map;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class User {

    private String name;
    private int children;
    private Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    public static void main(String[] args) {
        User user1 = new User("Bob", 1, new GregorianCalendar(1981, Calendar.JANUARY, 13));
        User user2 = new User("Bob", 1, new GregorianCalendar(1981, Calendar.JANUARY, 13));
        Map<User, Object> users = new HashMap<>();
        users.put(user1, new Object());
        users.put(user2, new Object());
        for (User user : users.keySet()) {
            System.out.println("key=" + user + " value=" + users.get(user));
        }
    }
}
