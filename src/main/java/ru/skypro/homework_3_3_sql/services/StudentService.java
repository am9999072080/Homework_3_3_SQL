package ru.skypro.homework_3_3_sql.services;

import ru.skypro.homework_3_3_sql.model.Student;

import java.util.Collection;

public interface StudentService {
    Student add(Student student);

    Student remove(Long id);

    Student update(Student student);

    Student get(Long id);

    Collection<Student> getByAge(Integer startAge, Integer endAge);

    Collection<Student> getAll();
}