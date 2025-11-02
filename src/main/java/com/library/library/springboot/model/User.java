package com.library.library.springboot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import javax.annotation.processing.Generated;
import java.time.LocalDate;

@Entity(name = "user_details")
public class User {
    @Id
    @GeneratedValue
    private int id;

    @Size(min = 3, message = "the min are 3 charchters for name")
    private String name;

    @Past(message = "Birth date should be in past")
    private LocalDate DOB;

    public User(int id, String name, LocalDate DOB) {
        this.id = id;
        this.name = name;
        this.DOB = DOB;
    }

    protected User() {}

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDOB() {
        return DOB;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDOB(LocalDate DOB) {
        this.DOB = DOB;
    }
}
