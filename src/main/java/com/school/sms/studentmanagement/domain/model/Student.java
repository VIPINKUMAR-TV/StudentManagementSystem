package com.school.sms.studentmanagement.domain.model;


import com.school.sms.studentmanagement.domain.valueobject.DateOfBirth;
import com.school.sms.studentmanagement.domain.valueobject.Division;
import com.school.sms.studentmanagement.domain.valueobject.StudentId;
import com.school.sms.studentmanagement.domain.valueobject.StudentName;

/**
 * Aggregate Root: Student
 * Enforces domain invariants:
 * - Must have valid StudentId
 * - Must have exactly one Parent
 * - DOB must be in the past
 * - Division must be A, B, or C
 */
public class Student {

    private final StudentId id;
    private StudentName name;
    private DateOfBirth dob;
    private Parent parent;
    private Division division;

    public Student(StudentId id,
                   StudentName name,
                   DateOfBirth dob,
                   Parent parent,
                   Division division) {

        if (id == null) throw new IllegalArgumentException("StudentId required");
        if (name == null) throw new IllegalArgumentException("StudentName required");
        if (dob == null) throw new IllegalArgumentException("DateOfBirth required");
        if (parent == null) throw new IllegalArgumentException("Parent required");
        if (division == null) throw new IllegalArgumentException("Division required");

        this.id = id;
        this.name = name;
        this.dob = dob;
        this.parent = parent;
        this.division = division;
    }

    // --- Behavior (State changes must go through aggregate) ---

    public void updateName(StudentName newName) {
        if (newName == null) throw new IllegalArgumentException("Name cannot be null");
        this.name = newName;
    }

    public void updateDivision(Division newDivision) {
        if (newDivision == null) throw new IllegalArgumentException("Division cannot be null");
        this.division = newDivision;
    }

    public void updateParent(Parent newParent) {
        if (newParent == null) throw new IllegalArgumentException("Parent cannot be null");
        this.parent = newParent;
    }

    // --- Getters (No setters to protect invariants) ---

    public StudentId getId() {
        return id;
    }

    public StudentName getName() {
        return name;
    }

    public DateOfBirth getDob() {
        return dob;
    }

    public Parent getParent() {
        return parent;
    }

    public Division getDivision() {
        return division;
    }
}
