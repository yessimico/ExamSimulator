Exam Simulator REST API
A RESTful API built with Spring Boot for managing an exam simulation system with candidates, teachers, staff, questions, and exams.
We can create questions for exam, we can create exam, manage candidates, teachers and staff

Entity Relationships

- Person (Abstract parent class)
      Candidate (Discriminator: "CANDIDATE")
      Teacher (Discriminator: "TEACHER")
      Staff (Discriminator: "STAFF")
- Question (has many options via @ElementCollection)
- Exam (many-to-many with Questions, many-to-one with Teacher)

Features

CRUD Operations for Candidates, Teachers, Staff, Questions, and Exams
RESTful API with JSON request/response
PostgreSQL Database integration
JPA/Hibernate for database operations
Service Layer architecture for business logic
Entity Inheritance using Single Table Strategy

Technologies Used

Java 17
Spring Boot 3.2.2
Spring Data JPA
PostgreSQL
Maven
Hibernate
