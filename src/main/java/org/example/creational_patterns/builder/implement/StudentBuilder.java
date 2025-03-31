package org.example.creational_patterns.builder.implement;

import java.util.Date;

public interface StudentBuilder {

    StudentBuilder setId(Integer id);
    StudentBuilder setName(String name);
    StudentBuilder setDateOfBirth(Date dateOfBirth);
    StudentBuilder setPhone(String phone);

    Student build();
}
