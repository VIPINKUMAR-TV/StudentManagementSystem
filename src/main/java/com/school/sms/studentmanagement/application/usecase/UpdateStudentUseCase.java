package com.school.sms.studentmanagement.application.usecase;



import com.school.sms.studentmanagement.domain.model.Parent;
import com.school.sms.studentmanagement.domain.model.Student;
import com.school.sms.studentmanagement.domain.repository.StudentRepository;
import com.school.sms.studentmanagement.domain.valueobject.*;

import org.springframework.stereotype.Service;

@Service
public class UpdateStudentUseCase {

    private final StudentRepository repository;

    public UpdateStudentUseCase(StudentRepository repository) {
        this.repository = repository;
    }

    public void execute(String studentId,
                        String newName,
                        String newParentName,
                        String newParentPhone,
                        String newDivision) {

        Student student = repository.findById(new StudentId(studentId))
                .orElseThrow(() -> new IllegalArgumentException("Student not found"));

        // Update via Aggregate behaviors
        student.updateName(new StudentName(newName));
        student.updateParent(new Parent(
                new ParentName(newParentName),
                new ParentPhone(newParentPhone)
        ));
        student.updateDivision(new Division(newDivision));

        repository.update(student);
    }
}

