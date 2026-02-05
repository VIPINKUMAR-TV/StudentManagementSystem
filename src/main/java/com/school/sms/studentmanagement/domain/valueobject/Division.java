package com.school.sms.studentmanagement.domain.valueobject;

import java.util.List;
import java.util.Objects;

/**
 * Value Object: Division
 * Rule: Must be A, B, or C.
 * Immutable and self-validating.
 */
public final class Division {

    private static final List<String> ALLOWED = List.of("A", "B", "C");

    private final String value;

    public Division(String value) {
        if (value == null || !ALLOWED.contains(value)) {
            throw new IllegalArgumentException("Invalid division. Allowed: A, B, C");
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    // Value Objects compare by value
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Division division)) return false;
        return value.equals(division.value);
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

