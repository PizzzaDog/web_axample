package ru.aston.repository;

import ru.aston.model.Student;

import java.util.List;

public interface StudentRepository {
    public List<Student> getAll();
    public Student getByName(String name);
}
