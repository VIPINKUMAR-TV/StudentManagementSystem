package com.school.sms.studentprofile.application.usecase;


import com.school.sms.studentmanagement.domain.model.Student;
import com.school.sms.studentmanagement.domain.repository.StudentRepository;
import com.school.sms.studentmanagement.domain.valueobject.StudentId;

import org.springframework.stereotype.Service;

@Service
public class GetStudentProfileUseCase {

    private final StudentRepository repository;

    public GetStudentProfileUseCase(StudentRepository repository) {
        this.repository = repository;
    }

    /**
     * Fetch student profile (read-only).
     */
    public Student execute(String studentId) {
        return repository.findById(new StudentId(studentId))
                .orElseThrow(() -> new IllegalArgumentException("Student not found"));
    }
}

