package com.yz.datasourcedemo.componet;

import java.lang.annotation.*;

/**
 * 多数据源注解
 * 指定要使用的数据源
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CurDataSource {

    String name() default "";
}
