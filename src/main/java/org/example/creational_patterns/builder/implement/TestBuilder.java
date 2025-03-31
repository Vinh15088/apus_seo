package org.example.creational_patterns.builder.implement;


import java.util.Date;

public class TestBuilder {
    public static void main(String[] args) {
        StudentBuilder studentBuilder = new StudentConcreteBuilder()
                .setId(1)
                .setName("vinhSeo")
                .setDateOfBirth(new Date())
                .setPhone("0123456789");

        System.out.println(studentBuilder.build().toString());
    }
}
