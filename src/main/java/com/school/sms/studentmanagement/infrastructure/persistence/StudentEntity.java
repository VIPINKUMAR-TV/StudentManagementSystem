package com.school.sms.studentmanagement.infrastructure.persistence;


import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "students")
public class StudentEntity {

    @Id
    @Column(name = "student_id")
    private String id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private LocalDate dob;

    @Column(name = "parent_name", nullable = false)
    private String parentName;

    @Column(name = "parent_phone", nullable = false)
    private String parentPhone;

    @Column(nullable = false)
    private String division;

    // JPA requires default constructor
    protected StudentEntity() {}

    public StudentEntity(String id, String name, LocalDate dob,
                         String parentName, String parentPhone, String division) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.parentName = parentName;
        this.parentPhone = parentPhone;
        this.division = division;
    }

    // Getters
    public String getId() { return id; }
    public String getName() { return name; }
    public LocalDate getDob() { return dob; }
    public String getParentName() { return parentName; }
    public String getParentPhone() { return parentPhone; }
    public String getDivision() { return division; }
}

