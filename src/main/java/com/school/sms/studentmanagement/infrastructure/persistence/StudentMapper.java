package com.school.sms.studentmanagement.infrastructure.persistence;



import com.school.sms.studentmanagement.domain.model.Parent;
import com.school.sms.studentmanagement.domain.model.Student;
import com.school.sms.studentmanagement.domain.valueobject.*;

public class StudentMapper {

    private StudentMapper() {}

    public static StudentEntity toEntity(Student student) {
        return new StudentEntity(
                student.getId().getValue(),
                student.getName().getValue(),
                student.getDob().getValue(),
                student.getParent().getName().getValue(),
                student.getParent().getPhone().getValue(),
                student.getDivision().getValue()
        );
    }

    public static Student toDomain(StudentEntity entity) {
        return new Student(
                new StudentId(entity.getId()),
                new StudentName(entity.getName()),
                new DateOfBirth(entity.getDob()),
                new Parent(
                        new ParentName(entity.getParentName()),
                        new ParentPhone(entity.getParentPhone())
                ),
                new Division(entity.getDivision())
        );
    }
}
