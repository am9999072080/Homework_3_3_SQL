package ru.skypro.homework_3_3_sql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.skypro.homework_3_3_sql.model.Student;

import java.util.Collection;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Collection<Student> findStudentsByAgeBetween(Integer startAge, Integer endAge);
}
