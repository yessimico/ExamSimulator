package com.example.entity;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("STAFF")
public class Staff extends Person {
    private String position;
    private String office;

    public Staff() {}

    public Staff(String name, String surname, int age, boolean sex, String position, String office) {
        super(name, surname, age, sex);
        this.position = position;
        this.office = office;
    }

    public String getPosition() { return position; }
    public void setPosition(String position) { this.position = position; }

    public String getOffice() { return office; }
    public void setOffice(String office) { this.office = office; }

    @Override
    public void printInfo() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "com.entity.Staff{id=" + getId() + ", name='" + getName() + "', position='" +
                position + "', office='" + office + "'}";
    }
}