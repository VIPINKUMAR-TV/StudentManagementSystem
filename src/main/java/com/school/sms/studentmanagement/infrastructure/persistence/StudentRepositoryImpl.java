package com.school.sms.studentmanagement.infrastructure.persistence;


import com.school.sms.studentmanagement.domain.model.Student;
import com.school.sms.studentmanagement.domain.repository.StudentRepository;
import com.school.sms.studentmanagement.domain.valueobject.StudentId;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class StudentRepositoryImpl implements StudentRepository {

    private final StudentJpaRepository jpaRepository;

    public StudentRepositoryImpl(StudentJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public void save(Student student) {
        StudentEntity entity = StudentMapper.toEntity(student);
        jpaRepository.save(entity);
    }

    @Override
    public void update(Student student) {
        StudentEntity entity = StudentMapper.toEntity(student);
        jpaRepository.save(entity);
    }

    @Override
    public void delete(StudentId id) {
        jpaRepository.deleteById(id.getValue());
    }

    @Override
    public Optional<Student> findById(StudentId id) {
        return jpaRepository.findById(id.getValue())
                .map(StudentMapper::toDomain);
    }

    @Override
    public List<Student> findAll() {
        return jpaRepository.findAll()
                .stream()
                .map(StudentMapper::toDomain)
                .collect(Collectors.toList());
    }
}
