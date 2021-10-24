package ru.job4j.gc.cache;

import java.io.BufferedReader;
import java.io.FileReader;

public class DirFileCache extends AbstractCache<String, String> {

    private final String cachingDir;

    public DirFileCache(String cachingDir) {
        this.cachingDir = cachingDir;
    }

    @Override
    protected String load(String key) {
        String value = null;
        String filePath = (cachingDir + "/" + key).replaceAll("/+", "/");
        try (BufferedReader in = new BufferedReader(new FileReader(filePath))) {
            StringBuilder sb = new StringBuilder();
            in.lines().forEach(sb::append);
            value = sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }
}
