package com.school.sms.studentmanagement.application.usecase;


import com.school.sms.studentmanagement.domain.repository.StudentRepository;
import com.school.sms.studentmanagement.domain.valueobject.StudentId;

import org.springframework.stereotype.Service;

@Service
public class DeleteStudentUseCase {

    private final StudentRepository repository;

    public DeleteStudentUseCase(StudentRepository repository) {
        this.repository = repository;
    }

    public void execute(String studentId) {

        StudentId id = new StudentId(studentId);

        repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Student not found"));

        repository.delete(id);
    }
}
