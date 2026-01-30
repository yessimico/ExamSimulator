package com.example.entity;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "person_type")
public abstract class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    protected String name;
    protected String surname;
    protected int age;
    protected boolean sex;

    public Person() {}
    public Person(String name, String surname, int age, boolean sex){
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.sex = sex;
    }

    public Long getId(){return id;}
    public void setId(Long id){this.id = id;}

    public String getName(){return name;}
    public void setName(String name){this.name = name;}

    public String getSurname(){return surname;}
    public void setSurname(String surname){this.surname = surname;}

    public int getAge(){return age;}
    public void setAge(int age){this.age = age;}

    public boolean getSex(){return sex;}
    public void setSex(boolean sex){this.sex = sex;}

    public abstract void printInfo();

    @Override
    public String toString() {
        return "com.entity.Person{id=" + id + ", name='" + name + "', surname='" + surname +
                "', age=" + age + ", sex=" + sex + "}";
    }
}
