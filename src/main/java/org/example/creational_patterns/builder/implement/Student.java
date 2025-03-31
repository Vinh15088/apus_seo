package org.example.creational_patterns.builder.implement;

import java.util.Date;

public class Student {
    private Integer id;
    private String name;
    private Date birthOfDate;
    private String phone;

    public Student(Integer id, String name, Date birthOfDate, String phone) {
        this.id = id;
        this.name = name;
        this.birthOfDate = birthOfDate;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthOfDate=" + birthOfDate +
                ", phone='" + phone + '\'' +
                '}';
    }
}
