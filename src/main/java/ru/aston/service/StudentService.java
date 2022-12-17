package ru.aston.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.aston.model.Student;
import ru.aston.repository.StudentRepository;
import ru.aston.repository.StudentRepositoryImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@Service
public class StudentService {

    private StudentRepositoryImpl studentRepository;
    @Autowired
    public StudentService(StudentRepositoryImpl studentRepository) {
        this.studentRepository = studentRepository;
    }

    //TODO
    public List<Student> getAllStudents() {
        return studentRepository.getAll();
    }

    //TODO
    public Student getStudent(String name) {
        return studentRepository.getByName(name);
    }

}
