package com.school.sms.studentmanagement.domain.model;

import com.school.sms.studentmanagement.domain.valueobject.ParentName;
import com.school.sms.studentmanagement.domain.valueobject.ParentPhone;

/**
 * Entity: Parent
 * Part of Student Aggregate.
 * A Student must always have exactly one Parent.
 */
public class Parent {

    private final ParentName name;
    private final ParentPhone phone;

    public Parent(ParentName name, ParentPhone phone) {
        if (name == null) throw new IllegalArgumentException("Parent name required");
        if (phone == null) throw new IllegalArgumentException("Parent phone required");

        this.name = name;
        this.phone = phone;
    }

    public ParentName getName() {
        return name;
    }

    public ParentPhone getPhone() {
        return phone;
    }
}
