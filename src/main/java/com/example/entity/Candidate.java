package com.example.entity;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("CANDIDATE")
public class Candidate extends Person {
    private int score;
    private String university;

    public Candidate() {}
    public Candidate(String name, String surname, int age, boolean sex, String university){
        super(name, surname, age, sex);
        this.score = 0;
        this.university = university;
    }

    @Transient
    public void answerQuestion(Question question, int answer){
        if (question.checkAnswer(answer)){
            score++;
        }
    }

    public int getScore(){return score;}
    public void setScore(int score){this.score = score;}

    public String getUniversity(){return university;}
    public void setUniversity(String university){this.university = university;}

    @Override
    public void printInfo(){
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "com.entity.Candidate{id=" + getId() + ", name='" + getName() + "', surname='" +
                getSurname() + "', age=" + getAge() + ", sex=" + getSex() +
                ", score=" + score + ", university='" + university + "'}";
    }
}
