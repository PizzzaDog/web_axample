package ru.aston.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
@PropertySource("classpath:application.properties")
public class DBConnection {

    private @Value("${db.url}") String DB_URL;

    private @Value("${db.login}") String DB_LOGIN;

    private @Value("${db.password}") String DB_PASSWORD;

    private static Connection connection;

    @Bean
    public Connection openConnection() {
        try {
            //TODO
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(DB_URL,DB_LOGIN,DB_PASSWORD);
        } catch (SQLException e) {
            System.out.println("Все походу плохо");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
}
