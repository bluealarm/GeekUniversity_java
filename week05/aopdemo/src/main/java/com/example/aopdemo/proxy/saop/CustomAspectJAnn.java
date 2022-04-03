package com.example.aopdemo.proxy.saop;

import java.lang.annotation.*;


@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CustomAspectJAnn {

    int cacheExpire() default 0;

}