package com.example.springsecurity.entity;

public class Student {
    private int id;
    private String name;
    private int mark;

    public Student(int id, int mark, String name) {
        this.id = id;
        this.mark = mark;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getMark() {
        return mark;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }


    
}
