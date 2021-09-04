package ru.job4j.collections.map;

import java.util.*;

public class User {

    private String name;
    private int children;
    private Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, children, birthday);
    }

    public static void main(String[] args) {
        Calendar birthday = new GregorianCalendar(
                1981,
                Calendar.JANUARY,
                13,
                0,
                0,
                0
        );
        birthday.set(Calendar.MILLISECOND, 0);
        User user1 = new User("Bob", 1, birthday);
        User user2 = new User("Bob", 1, birthday);
        Map<User, Object> users = new HashMap<>();
        users.put(user1, new Object());
        users.put(user2, new Object());
        for (User user : users.keySet()) {
            System.out.println("key=" + user + " value=" + users.get(user));
        }
    }
}
