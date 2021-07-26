package ru.geekbrains.interview_hibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@ComponentScan("ru.geekbrains.interview_hibernate")
public class StudentApp {
    @Autowired
    private StudentRepository studentRepository;

    @PostConstruct
    void test() {
        Student s = new Student("Katya", 55);
        Student s2 = studentRepository.insert(s);
        System.out.println("s2 = " + s2);

        Student s3 = studentRepository.findById(1);
        System.out.println("s3 = " + s3);
        s3.setMark(33333);
        Student s4 = studentRepository.update(s3);
        System.out.println("s4 = " + s4);

        System.out.println(studentRepository.deleteById(2));

        System.out.println(studentRepository.findAll());
    }
}
