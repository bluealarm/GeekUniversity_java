package com.example.aopdemo.proxy.saop;

import com.example.aopdemo.proxy.saop.CustomAspectJAnn;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
//import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.Method;


@Aspect
@SuppressWarnings("all")
@Component
public class CustomBaseAspectJ {

    //切入点
    @Pointcut("@annotation(com.example.aopdemo.proxy.saop.CustomAspectJAnn)")
//    @Pointcut("execution(public * com.springboot.frame.proxy.*.*(..))")
    public void customPointcut() {
        System.out.println(1);
    }

    //切入点之前的逻辑
    @Before("customPointcut()")
    public void beforeAdvice() {
        System.out.println("PersonProxy.doAdvice() start ....");
    }

    //切入点之后的逻辑
    @After("customPointcut()")
    public void afterAdvice() throws NoSuchMethodException, ClassNotFoundException {
        System.out.println("PersonProxy.doAdvice() end ....");

        //反射拿到注解的值
        Method doing = PersonServiceImpl.class.getMethod("doing");
        System.out.println(doing.getAnnotation(CustomAspectJAnn.class).cacheExpire());

    }

    //写入点之后异常处理逻辑
    @AfterThrowing(value = "customPointcut()", throwing = "e")
    public void afterThrowingAdvice(JoinPoint joinPoint, Throwable e) {
        e.printStackTrace();
    }
}
