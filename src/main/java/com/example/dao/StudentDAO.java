package com.example.dao;

import com.example.entity.Student;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class StudentDAO implements StudentDAOable {

    private final EntityManager entityManager;

    @Autowired
    public StudentDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    @Override
    public void save(Student entity) {
        entityManager.persist(entity);
    }

    @Override
    public Student getById(int id) {
        return entityManager.find(Student.class, id);
    }
}
