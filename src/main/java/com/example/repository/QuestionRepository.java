package com.example.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.entity.Question;


@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {}
