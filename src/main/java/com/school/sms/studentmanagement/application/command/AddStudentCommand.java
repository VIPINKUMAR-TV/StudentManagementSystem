package com.school.sms.studentmanagement.application.command;


import java.time.LocalDate;

/**
 * Command DTO for Add Student Use Case
 * Carries user input from controller to application layer.
 */
public record AddStudentCommand(
        String name,
        LocalDate dob,
        String parentName,
        String parentPhone,
        String division
) {}
