package com.example.aopdemo.school;

import java.util.List;

public class MyClass {

    private List<com.example.aopdemo.school.Student> students;

    public List<com.example.aopdemo.school.Student> getStudents() {
        return students;
    }

    public void setStudents(List<com.example.aopdemo.school.Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "MyClass::" + students.toString();
    }
}
