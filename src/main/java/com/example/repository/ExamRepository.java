package com.example.repository;
import com.example.entity.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import com.example.entity.Teacher;

public interface ExamRepository extends JpaRepository<Exam, Long> {
    List<Exam> findByName(String name);
    List<Exam> findByTeacher(Teacher teacher);
}

