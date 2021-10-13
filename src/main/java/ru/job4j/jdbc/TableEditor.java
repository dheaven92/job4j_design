package ru.job4j.jdbc;

import ru.job4j.io.Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.StringJoiner;

public class TableEditor implements AutoCloseable {

    private Connection connection;
    private final Properties properties;

    public TableEditor(Properties properties) throws SQLException, ClassNotFoundException {
        this.properties = properties;
        initConnection();
    }

    private void initConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection(
                properties.getProperty("url"),
                properties.getProperty("login"),
                properties.getProperty("password")
        );
    }

    public void createTable(String tableName) throws Exception {
        executeStatement(String.format("create table if not exists %s();", tableName));
        System.out.printf("table \"%s\" was created successfully%n", tableName);
        System.out.println(getTableScheme(connection, tableName));
    }

    public void dropTable(String tableName) throws SQLException {
        executeStatement(String.format("drop table if exists %s;", tableName));
        System.out.printf("table \"%s\" was dropped successfully%n", tableName);
    }

    public void addColumn(String tableName, String columnName, String type) throws Exception {
        executeStatement(String.format("alter table %s add column %s %s;", tableName, columnName, type));
        System.out.printf("column \"%s\" was added to table \"%s\"%n", columnName, tableName);
        System.out.println(getTableScheme(connection, tableName));
    }

    public void dropColumn(String tableName, String columnName) throws Exception {
        executeStatement(String.format("alter table %s drop column %s;", tableName, columnName));
        System.out.printf("column \"%s\" was dropped from table \"%s\"%n", columnName, tableName);
        System.out.println(getTableScheme(connection, tableName));
    }

    public void renameColumn(String tableName, String columnName, String newColumnName) throws Exception {
        executeStatement(String.format("alter table %s rename column %s to %s", tableName, columnName, newColumnName));
        System.out.printf("column \"%s\" was renamed to \"%s\" in table \"%s\"%n", columnName, newColumnName, tableName);
        System.out.println(getTableScheme(connection, tableName));
    }

    public static String getTableScheme(Connection connection, String tableName) throws Exception {
        var rowSeparator = "-".repeat(30).concat(System.lineSeparator());
        var header = String.format("%-15s|%-15s%n", "NAME", "TYPE");
        var buffer = new StringJoiner(rowSeparator, rowSeparator, rowSeparator);
        buffer.add(header);
        try (var statement = connection.createStatement()) {
            var selection = statement.executeQuery(String.format(
                    "select * from %s limit 1", tableName
            ));
            var metaData = selection.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                buffer.add(String.format("%-15s|%-15s%n",
                        metaData.getColumnName(i), metaData.getColumnTypeName(i))
                );
            }
        }
        return buffer.toString();
    }

    private void executeStatement(String sql) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
        }
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }

    public static void main(String[] args) throws Exception {
        Config config = new Config(ClassLoader.getSystemResource("app.properties").getPath());
        config.load();
        Properties properties = new Properties();
        properties.setProperty("url", config.value("db.url"));
        properties.setProperty("login", config.value("db.login"));
        properties.setProperty("password", config.value("db.password"));
        TableEditor tableEditor = new TableEditor(properties);
        tableEditor.createTable("test");
        tableEditor.addColumn("test", "col1", "varchar (256)");
        tableEditor.renameColumn("test", "col1", "col11");
        tableEditor.dropColumn("test", "col11");
        tableEditor.dropTable("test");
    }
}
