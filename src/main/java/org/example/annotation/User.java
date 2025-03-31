package org.example.annotation;

import org.example.annotation.custom.DBField;
import org.example.annotation.custom1.PhoneValidation;

import java.util.Date;

public class User {

    @DBField(name = "id", type = Integer.class, isPrimaryKey = true)
    private Integer id;

    @DBField(name = "name", type = String.class)
    private String name;

    @DBField(name = "email", type = String.class)
    private String email;

    @PhoneValidation
    private String phone;

    @DBField(name = "date_of_birth", type = Date.class)
    private Date dateOfBirth;

    public User() {

    }

    public User(String phone) {
        this.phone = phone;
    }

    public Integer getId() {
        return id;
    }

//    @Deprecated
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
