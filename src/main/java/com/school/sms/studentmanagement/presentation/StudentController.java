package com.school.sms.studentmanagement.presentation;


import com.school.sms.studentmanagement.application.command.AddStudentCommand;
import com.school.sms.studentmanagement.application.usecase.*;

import com.school.sms.studentmanagement.domain.model.Student;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final AddStudentUseCase addStudentUseCase;
    private final UpdateStudentUseCase updateStudentUseCase;
    private final DeleteStudentUseCase deleteStudentUseCase;
    private final GetAllStudentsUseCase getAllStudentsUseCase;

    public StudentController(AddStudentUseCase addStudentUseCase,
                             UpdateStudentUseCase updateStudentUseCase,
                             DeleteStudentUseCase deleteStudentUseCase,
                             GetAllStudentsUseCase getAllStudentsUseCase) {
        this.addStudentUseCase = addStudentUseCase;
        this.updateStudentUseCase = updateStudentUseCase;
        this.deleteStudentUseCase = deleteStudentUseCase;
        this.getAllStudentsUseCase = getAllStudentsUseCase;
    }

    // ➕ Add Student
    @PostMapping
    public void addStudent(@RequestBody AddStudentCommand command) {
        addStudentUseCase.execute(command);
    }

    // ✏ Update Student
    @PutMapping("/{id}")
    public void updateStudent(@PathVariable String id,
                              @RequestParam String name,
                              @RequestParam String parentName,
                              @RequestParam String parentPhone,
                              @RequestParam String division) {
        updateStudentUseCase.execute(id, name, parentName, parentPhone, division);
    }

    // ❌ Delete Student
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable String id) {
        deleteStudentUseCase.execute(id);
    }

    // 📋 Get All Students (Admin Dashboard)
    @GetMapping
    public List<Student> getAllStudents() {
        return getAllStudentsUseCase.execute();
    }
}

