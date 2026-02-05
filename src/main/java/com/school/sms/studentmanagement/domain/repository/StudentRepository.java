package com.school.sms.studentmanagement.domain.repository;


import com.school.sms.studentmanagement.domain.model.Student;
import com.school.sms.studentmanagement.domain.valueobject.StudentId;

import java.util.List;
import java.util.Optional;

/**
 * Repository Contract for Student Aggregate.
 * Domain depends only on this abstraction.
 */
public interface StudentRepository {

    void save(Student student);

    void update(Student student);

    void delete(StudentId id);

    Optional<Student> findById(StudentId id);

    List<Student> findAll();
}

