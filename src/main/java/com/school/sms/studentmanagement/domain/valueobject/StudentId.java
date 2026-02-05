package com.school.sms.studentmanagement.domain.valueobject;


import java.util.Objects;

/**
 * Value Object: StudentId
 * Rule: Must start with "STU"
 * Immutable and self-validating.
 */
public final class StudentId {

    private final String value;

    public StudentId(String value) {
        if (value == null || !value.startsWith("STU")) {
            throw new IllegalArgumentException("Invalid Student ID");
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    // Value Objects compare by value, not identity
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StudentId that)) return false;
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
