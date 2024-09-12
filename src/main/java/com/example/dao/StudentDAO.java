package com.example.dao;

import com.example.entity.Student;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Override
    public List<Student> getAll() {
        var query = entityManager.createQuery("from Student order by firstName asc", Student.class);
        return query.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        var query = entityManager.createQuery("from Student where lastName like :lastName", Student.class);

        query.setParameter("lastName", "%" + lastName + "%");

        return query.getResultList();
    }

    @Transactional
    @Override
    public Student update(Student entity) {
        return entityManager.merge(entity);
    }

    @Transactional
    @Override
    public void deleteById(int id) {
        var student = entityManager.find(Student.class, id);
        entityManager.remove(student);
    }

    @Override
    public int deleteAll() {
        var query = entityManager.createQuery("delete from Student");
        return query.executeUpdate();
    }
}
