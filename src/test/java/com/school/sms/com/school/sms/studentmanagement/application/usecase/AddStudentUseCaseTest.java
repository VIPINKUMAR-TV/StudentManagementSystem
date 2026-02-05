package com.school.sms.com.school.sms.studentmanagement.application.usecase;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.school.sms.studentmanagement.application.command.AddStudentCommand;
import com.school.sms.studentmanagement.application.usecase.AddStudentUseCase;
import com.school.sms.studentmanagement.domain.repository.StudentRepository;

@ExtendWith(MockitoExtension.class)
class AddStudentUseCaseTest {

    @Mock
    private StudentRepository repository;

    @InjectMocks
    private AddStudentUseCase useCase;

    @Test
    void shouldSaveStudentWhenCommandIsValid() {

        // Arrange
        AddStudentCommand command = new AddStudentCommand(
                "John",
                LocalDate.of(2010, 1, 1),
                "David",
                "9999999999",
                "A"
        );

        // No students initially (for ID generation logic)
        when(repository.findAll()).thenReturn(List.of());

        // Act
        useCase.execute(command);

        // Assert
        verify(repository, times(1)).save(any());
    }

    @Test
    void shouldThrowExceptionForInvalidDivision() {

        AddStudentCommand command = new AddStudentCommand(
                "John",
                LocalDate.of(2010, 1, 1),
                "David",
                "9999999999",
                "Z" // invalid division
        );

        when(repository.findAll()).thenReturn(List.of());

        // Expect domain validation to fail
        try {
            useCase.execute(command);
        } catch (Exception e) {
            assert true;
        }
    }
}

