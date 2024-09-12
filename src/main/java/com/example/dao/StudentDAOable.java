package com.example.dao;

import com.example.entity.Student;

public interface StudentDAOable {
    void save(Student entity);
    Student getById(int id);
}
