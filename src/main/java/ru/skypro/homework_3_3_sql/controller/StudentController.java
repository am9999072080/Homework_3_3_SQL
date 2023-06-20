package ru.skypro.homework_3_3_sql.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.skypro.homework_3_3_sql.model.Faculty;
import ru.skypro.homework_3_3_sql.model.Student;
import ru.skypro.homework_3_3_sql.services.StudentService;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.Collection;

@RestController
@RequestMapping("student")
@Tag(name = "Api: Для работы со студентами")
public class StudentController {
    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @PostMapping
    @Operation(summary = "Создание студента")
    public ResponseEntity<Student> create(@RequestBody Student student) {
        Student addedStudent = service.add(student);
        return ResponseEntity.ok(addedStudent);
    }

    @PutMapping
    @Operation(summary = "Обновление студента")
    @ApiResponse(responseCode = "404", description = "Запрос некорректный")
    public ResponseEntity<Student> update(@RequestBody Student student) {
        Student updatedStudent = service.update(student);

        return ResponseEntity.ok(updatedStudent);
    }

    @DeleteMapping({"{id}"})
    @ApiResponse(responseCode = "404", description = "Запрос некорректный")
    @Operation(summary = "Удаление студента")
    public ResponseEntity<Student> delete(@PathVariable Long id) {
        Student deletedStudent = service.remove(id);

        return ResponseEntity.ok(deletedStudent);
    }

    @GetMapping({"{id}"})
    @ApiResponse(responseCode = "404", description = "Запрос некорректный")
    @Operation(summary = "Получение студента по ID")
    public ResponseEntity<Student> get(@PathVariable Long id) {
        Student student = service.get(id);

        return ResponseEntity.ok(student);
    }

    @GetMapping({"all"})
    @Operation(summary = "Получение списка всех студентов")
    public ResponseEntity<Collection<Student>> getAll() {
        Collection<Student> students = service.getAll();
        return ResponseEntity.ok(students);
    }

    @GetMapping("age")
    @Operation(summary = "Получение списка всех студентов по возрасту")
    public ResponseEntity<Collection<Student>> getByAge(@RequestParam Integer startAge,
                                                        @RequestParam Integer endAge) {
        Collection<Student> students = service.getByAge(startAge, endAge);
        return ResponseEntity.ok(students);
    }

    @GetMapping({"faculty/{studentId}"})
    @Operation(summary = "Получение по факультету студента")
    public ResponseEntity<Faculty> getFaculty(@PathVariable Long studentId) {
        Faculty faculty = service.get(studentId).getFaculty();
        return ResponseEntity.ok(faculty);
    }
}
