package com.example.schooldemo.starter;

import java.util.ArrayList;
import java.util.List;

public class MyClass {
    private int id;
    private String name;

    public MyClass(int id, String name) {
        this.id = id;
        this.name = name;
    }

    private List<com.example.schooldemo.starter.Student> students = new ArrayList<>();

    public void addStudent(com.example.schooldemo.starter.Student student) {
        students.add(student);
    }

    @Override
    public String toString() {
        return "MyClass::" + students.toString();
    }
}
