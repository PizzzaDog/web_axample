package ru.aston.repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import ru.aston.model.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {

    @Value("${db.url}")
    private static String DB_URL;

    @Value("${db.login}")
    private static String DB_LOGIN;

    @Value("${db.password}")
    private static String DB_PASSWORD;

    private static Connection connection;

    static {
        try {
            Class.forName("org.postgresql.Driver");
            //TODO
//            connection = DriverManager.getConnection(DB_URL, DB_LOGIN, DB_PASSWORD);
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://127.0.0.1:5432/axample",
                    "postgres",
                    "Sevennation1");

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Все походу плохо");
        }
    }


//    @PostConstruct
    private void postConstruct() {

    }


    public Student getByName(String name) {

        Student student = new Student();

        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(
                    "select * from student s " +
                    "where s.name= '" + name + "'");

            while (rs.next()) {
                student.setName(rs.getString(1));
                student.setAge(rs.getInt(2));
            }

        } catch (SQLException e) {
            System.out.println("Мы не умеем работать с бд");
        }

        return student;
    }

    public List<Student> getAll() {
        List<Student> result = new ArrayList<>();

        try {

            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from student");

            while (rs.next()) {
                Student student = new Student();
                student.setName(rs.getString(1));
                student.setAge(rs.getInt(2));
                result.add(student);
            }

        } catch (SQLException e) {
            System.out.println("Мы не умеем работать с бд");
        }
        return result;
    }
}
