package com.example.aopdemo;

import com.example.aopdemo.javacode.MyJavaCodeConfig;
import com.example.aopdemo.javacode.MyJavaCodeExample;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyJavaCodeExampleTest {

    @Test
    public void test() {
        AnnotationConfigApplicationContext configApplicationContext =
                new AnnotationConfigApplicationContext(com.example.aopdemo.javacode.MyJavaCodeConfig.class);
        MyJavaCodeExample example = (MyJavaCodeExample) configApplicationContext.getBean("javaCodeExample");
        example.info();
    }
}
