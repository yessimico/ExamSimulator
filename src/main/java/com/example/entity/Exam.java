package com.example.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToMany
    @JoinTable(
            name = "exam_questions",
            joinColumns = @JoinColumn(name = "exam_id"),
            inverseJoinColumns = @JoinColumn(name = "question_id")
    )
    private List<Question> questions;
    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    public Exam() {};
    public Exam(String name, List<Question> questions){
        this.name = name;
        this.questions = questions;
    }

    public Long getId(){return id;}
    public void setId(Long id){this.id = id;}

    public String getName(){return name;}
    public void setName(String name){this.name = name;}

    public List<Question> getQuestions(){return questions;}
    public void setQuestions(List<Question> questions){this.questions = questions;}

    public Teacher getTeacher(){return teacher;}
    public void setTeacher(Teacher teacher){this.teacher = teacher;}
}
