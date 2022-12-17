package ru.aston.repository;

import org.springframework.stereotype.Repository;
import ru.aston.config.DBConnection;
import ru.aston.config.MyConfig;
import ru.aston.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepositoryImpl implements StudentRepository {

    DBConnection dataBase = new DBConnection();

    private static final String SELECT_STUDENT_BY_NAME = "select * from student s where s.name=?";
    private static final String SELECT_ALL_STUDENTS = "select * from student";



    public Student getByName(String name) {

        Student student = new Student();

        try {
            Connection connection = dataBase.openConnection();
            PreparedStatement statement = connection.prepareStatement(SELECT_STUDENT_BY_NAME);
            statement.setString(1, name);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                student.setId(rs.getLong(1));
                student.setName(rs.getString(2));
                student.setAge(rs.getInt(3));
            }

        } catch (SQLException e) {
            System.out.println("Мы не умеем работать с бд");
        }

        return student;
    }

    public List<Student> getAll() {
        List<Student> result = new ArrayList<>();

        try {
            Connection connection = dataBase.openConnection();
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL_STUDENTS);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getLong(1));
                student.setName(rs.getString(2));
                student.setAge(rs.getInt(3));
                result.add(student);
            }

        } catch (SQLException e) {
            System.out.println("Мы не умеем работать с бд");
        }
        return result;
    }
}
