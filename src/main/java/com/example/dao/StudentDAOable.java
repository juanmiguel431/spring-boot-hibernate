package com.example.dao;

import com.example.entity.Student;

import java.util.List;

public interface StudentDAOable {
    void save(Student entity);
    Student getById(int id);
    List<Student> getAll();
    List<Student> findByLastName(String lastName);
    Student update(Student entity);
}
