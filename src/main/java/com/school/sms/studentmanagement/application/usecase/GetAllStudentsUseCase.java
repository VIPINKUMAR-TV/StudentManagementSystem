package com.school.sms.studentmanagement.application.usecase;



import com.school.sms.studentmanagement.domain.model.Student;
import com.school.sms.studentmanagement.domain.repository.StudentRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllStudentsUseCase {

    private final StudentRepository repository;

    public GetAllStudentsUseCase(StudentRepository repository) {
        this.repository = repository;
    }

    /**
     * Returns all students for Admin dashboard view.
     */
    public List<Student> execute() {
        return repository.findAll();
    }
}
