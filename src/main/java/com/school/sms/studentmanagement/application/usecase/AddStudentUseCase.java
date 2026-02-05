package com.school.sms.studentmanagement.application.usecase;



import com.school.sms.studentmanagement.application.command.AddStudentCommand;
import com.school.sms.studentmanagement.domain.model.Parent;
import com.school.sms.studentmanagement.domain.model.Student;
import com.school.sms.studentmanagement.domain.repository.StudentRepository;
import com.school.sms.studentmanagement.domain.service.StudentIdGenerator;
import com.school.sms.studentmanagement.domain.valueobject.*;

import org.springframework.stereotype.Service;

@Service
public class AddStudentUseCase {

    private final StudentRepository repository;

    public AddStudentUseCase(StudentRepository repository) {
        this.repository = repository;
    }

    /**
     * Executes the Add Student business flow.
     */
    public void execute(AddStudentCommand cmd) {

        long count = repository.findAll().size();

        Student student = new Student(
                StudentIdGenerator.generate(count),
                new StudentName(cmd.name()),
                new DateOfBirth(cmd.dob()),
                new Parent(
                        new ParentName(cmd.parentName()),
                        new ParentPhone(cmd.parentPhone())
                ),
                new Division(cmd.division())
        );

        repository.save(student);
    }
}
