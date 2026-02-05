package com.school.sms.studentmanagement.domain.service;


import com.school.sms.studentmanagement.domain.valueobject.StudentId;

/**
 * Domain Service: StudentIdGenerator
 * Generates Student IDs in format STU1000 + count
 */
public class StudentIdGenerator {

    private static final int BASE = 1000;

    private StudentIdGenerator() {
        // Prevent instantiation
    }

    public static StudentId generate(long currentCount) {
        String generated = "STU" + (BASE + currentCount);
        return new StudentId(generated);
    }
}

