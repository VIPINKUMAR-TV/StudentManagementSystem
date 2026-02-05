package com.school.sms.studentmanagement.domain.valueobject;


import java.util.Objects;

/**
 * Value Object: StudentName
 * Rule: Name cannot be empty or blank.
 * Immutable and self-validating.
 */
public final class StudentName {

    private final String value;

    public StudentName(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("Student name cannot be empty");
        }
        this.value = value.trim();
    }

    public String getValue() {
        return value;
    }

    // Equality based on value
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StudentName that)) return false;
        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return value;
    }
}

