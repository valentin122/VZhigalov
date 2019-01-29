package ru.job4j.tander

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import java.io.Closeable;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import java.io.InputStream;


public class Config {
    private final Properties values = new Properties();

    public void init() {
        try (InputStream in = Config.class.getClassLoader().getResourceAsStream("app.properties")) {
            values.load(in);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    public String get(String key) {

        return this.values.getProperty(key);
    }
}
