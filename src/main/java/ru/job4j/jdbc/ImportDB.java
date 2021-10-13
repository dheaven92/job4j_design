package ru.job4j.jdbc;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ImportDB {

    private final Properties cfg;
    private final String dump;

    public ImportDB(Properties cfg, String dump) {
        this.cfg = cfg;
        this.dump = dump;
    }

    public List<User> load() throws IOException {
        List<User> users = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(dump))) {
            for (String line = in.readLine(); line != null; line = in.readLine()) {
                try {
                    String[] parts = line.split(";");
                    String name = parts[0];
                    String email = parts[1];
                    users.add(new User(name, email));
                } catch (Exception e) {
                    throw new IllegalArgumentException("Invalid file format");
                }
            }
        }
        return users;
    }

    public void save(List<User> users) throws ClassNotFoundException, SQLException {
        Class.forName(cfg.getProperty("db.driver"));
        try (Connection cnt = DriverManager.getConnection(
                cfg.getProperty("db.url"),
                cfg.getProperty("db.login"),
                cfg.getProperty("db.password")
        )) {
            for (User user : users) {
                try (Statement s = cnt.createStatement()) {
                    s.execute(
                    """
                            create table if not exists users(
                                id serial primary key,\s
                                name varchar (256),\s
                                email varchar (256)
                            );
                        """
                    );
                }
                try (PreparedStatement ps = cnt.prepareStatement("insert into users (name, email) values (?, ?)")) {
                    ps.setString(1, user.name);
                    ps.setString(2, user.email);
                    ps.execute();
                }
            }
        }
    }

    private static class User {
        String name;
        String email;

        public User(String name, String email) {
            this.name = name;
            this.email = email;
        }
    }

    public static void main(String[] args) throws Exception {
        Properties cfg = new Properties();
        try (FileInputStream in = new FileInputStream(
                ClassLoader.getSystemResource("app.properties").getFile())
        ) {
            cfg.load(in);
        }
        ImportDB db = new ImportDB(cfg, "./data/dump.txt");
        db.save(db.load());
    }
}
