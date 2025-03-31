package org.example.creational_patterns.builder.implement;

import java.util.Date;

public class StudentConcreteBuilder implements StudentBuilder {

    private Integer id;
    private String name;
    private Date birthOfDate;
    private String phone;

    @Override
    public StudentBuilder setId(Integer id) {
        this.id = id;
        return this;
    }

    @Override
    public StudentBuilder setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public StudentBuilder setDateOfBirth(Date dateOfBirth) {
        this.birthOfDate = dateOfBirth;
        return this;
    }

    @Override
    public StudentBuilder setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    @Override
    public Student build() {
        return new Student(id, name, birthOfDate, phone);
    }


    @Override
    public String toString() {
        return "StudentConcreteBuilder{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthOfDate=" + birthOfDate +
                ", phone='" + phone + '\'' +
                '}';
    }
}
