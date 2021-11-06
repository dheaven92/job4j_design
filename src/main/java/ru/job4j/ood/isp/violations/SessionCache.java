package ru.job4j.ood.isp.violations;

public class SessionCache implements MultiConnector {

    @Override
    public void connectToPostgres() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void connectToRedis() {
        System.out.println("Connecting to redis to fetch sessions...");
    }

    @Override
    public void connectToCassandra() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void connectToMongo() {
        throw new UnsupportedOperationException();
    }
}
