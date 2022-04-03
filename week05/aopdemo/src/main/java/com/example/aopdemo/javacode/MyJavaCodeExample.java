package com.example.aopdemo.javacode;

import org.springframework.stereotype.Component;


@Component
public class MyJavaCodeExample {

    public MyJavaCodeExample() {
        System.out.println("Construct Example");
    }

    public void info() {
        System.out.println("Auto wiring example");
    }
}
