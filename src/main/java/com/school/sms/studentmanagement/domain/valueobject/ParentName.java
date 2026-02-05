package com.school.sms.studentmanagement.domain.valueobject;

import java.util.Objects;

/**
 * Value Object: ParentName
 * Rule: Parent name is required and cannot be empty.
 * Immutable and self-validating.
 */
public final class ParentName {

    private final String value;

    public ParentName(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("Parent name required");
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
        if (!(o instanceof ParentName that)) return false;
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

