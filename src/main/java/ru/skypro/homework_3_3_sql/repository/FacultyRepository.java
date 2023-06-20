package ru.skypro.homework_3_3_sql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.skypro.homework_3_3_sql.model.Faculty;


import java.util.Collection;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {
    Collection<Faculty> findFacultiesByNameIgnoreCaseOrColorIgnoreCase(String name, String color);
}
