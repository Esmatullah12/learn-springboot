package com.library.library.springboot.model;

import java.time.LocalDate;

public class User {
    private int id;
    private String name;
    private LocalDate DOB;

    public User(int id, String name, LocalDate DOB) {
        this.id = id;
        this.name = name;
        this.DOB = DOB;
    }

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
