package com.school.sms.studentmanagement.domain.valueobject;

import java.util.Objects;

/**
 * Value Object: ParentPhone
 * Rule: Must be exactly 10 digits.
 * Immutable and self-validating.
 */
public final class ParentPhone {

    private final String value;

    public ParentPhone(String value) {
        if (value == null || !value.matches("\\d{10}")) {
            throw new IllegalArgumentException("Invalid phone number. Must be 10 digits.");
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    // Equality based on value
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ParentPhone that)) return false;
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

