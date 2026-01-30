package com.example.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;

    @ElementCollection
    @CollectionTable(name = "question_options", joinColumns = @JoinColumn(name = "question_id"))
    @Column(name = "option_text")
    private List<String> options;
    private int correctOption;

    public Question() {};
    public Question(String text, List<String> options, int correctOption){
        this.text = text;
        this.options = options;
        this.correctOption = correctOption;
    }

    public boolean checkAnswer(int answer){return answer == correctOption;}

    public Long getId(){return id;}
    public void setId(Long id){this.id = id;}

    public String getText(){return text;}
    public void setText(String text){this.text = text;}

    public List<String> getOptions(){return options;}
    public void setOptions(List<String> options){this.options = options;}

    public int getCorrectOption(){return correctOption;}
    public void setCorrectOption(int correctOption){this.correctOption = correctOption;}
}
