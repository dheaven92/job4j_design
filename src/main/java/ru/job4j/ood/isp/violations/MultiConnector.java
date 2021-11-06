package ru.job4j.ood.isp.violations;

public interface MultiConnector {

    void connectToPostgres();

    void connectToRedis();

    void connectToCassandra();

    void connectToMongo();
}
