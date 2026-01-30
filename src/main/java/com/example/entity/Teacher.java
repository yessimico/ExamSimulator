package com.example.entity;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("TEACHER")
public class Teacher extends Person {
    private String department;
    private String subject;

    public Teacher() {}
    public Teacher(String name, String surname, int age, boolean sex, String department, String subject){
        super(name, surname, age, sex);
        this.department = department;
        this.subject = subject;
    }

    public String getDepartment(){return department;}
    public void setDepartment(String department){this.department = department;}

    public String getSubject() {return subject;}
    public void setSubject(String subject) {this.subject = subject;}

    @Override
    public void printInfo(){
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "com.entity.Teacher{id=" + getId() + ", name='" + getName() + "', surname='" +
                getSurname() + "', department='" + department + "', subject='" + subject + "'}";
    }
}
