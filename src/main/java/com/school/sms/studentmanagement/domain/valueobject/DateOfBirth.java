package com.school.sms.studentmanagement.domain.valueobject;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Value Object: DateOfBirth
 * Rule: DOB cannot be in the future.
 * Immutable and self-validating.
 */
public final class DateOfBirth {

    private final LocalDate value;

    public DateOfBirth(LocalDate value) {
        if (value == null) {
            throw new IllegalArgumentException("Date of Birth required");
        }
        if (value.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("DOB cannot be in the future");
        }
        this.value = value;
    }

    public LocalDate getValue() {
        return value;
    }

    // Equality based on value
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DateOfBirth that)) return false;
        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return value.toString();
    }
}

