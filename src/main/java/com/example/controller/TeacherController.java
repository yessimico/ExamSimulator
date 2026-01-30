package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.example.entity.Teacher;
import com.example.repository.TeacherRepository;

@RestController
@RequestMapping("/api/teachers")
public class TeacherController {

    @Autowired
    private TeacherRepository repository;

    @PostMapping
    public ResponseEntity<Teacher> createTeacher(@RequestBody Teacher teacher) {
        Teacher saved = repository.save(teacher);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Teacher>> getAllTeachers() {
        List<Teacher> teachers = repository.findAll();
        return ResponseEntity.ok(teachers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Teacher> getTeacherById(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/department/{department}")
    public ResponseEntity<List<Teacher>> getTeachersByDepartment(@PathVariable String department) {
        List<Teacher> teachers = repository.findByDepartment(department);
        return ResponseEntity.ok(teachers);
    }

    @GetMapping("/subject/{subject}")
    public ResponseEntity<List<Teacher>> getTeachersBySubject(@PathVariable String subject) {
        List<Teacher> teachers = repository.findBySubject(subject);
        return ResponseEntity.ok(teachers);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Teacher> updateTeacher(@PathVariable Long id, @RequestBody Teacher details) {
        return repository.findById(id)
                .map(teacher -> {
                    teacher.setName(details.getName());
                    teacher.setSurname(details.getSurname());
                    teacher.setAge(details.getAge());
                    teacher.setSex(details.getSex());
                    teacher.setDepartment(details.getDepartment());
                    teacher.setSubject(details.getSubject());
                    Teacher updated = repository.save(teacher);
                    return ResponseEntity.ok(updated);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTeacher(@PathVariable Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}