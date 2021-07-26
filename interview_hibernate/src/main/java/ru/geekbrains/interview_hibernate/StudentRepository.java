package ru.geekbrains.interview_hibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class StudentRepository extends AbstractRepository<Student, Integer> {

    @Autowired
    StudentRepository(EntityManager em) {
        super(em, Student.class);
    }
}
