package com.example.aopdemo.proxy.javassists;


import com.example.aopdemo.proxy.statics.Person;
import javassist.util.proxy.MethodHandler;
import javassist.util.proxy.ProxyFactory;

import java.lang.reflect.Method;


public class PersonMethodHandler implements MethodHandler {

    @Override
    public Object invoke(Object o, Method method, Method method1, Object[] objects) throws Throwable {
        System.out.println("PersonProxy.doAdvice() start ....");
        Object result = method1.invoke(o, objects);
        System.out.println("PersonProxy.doAdvice() end ....");
        return result;
    }

    public static Object createJavassistProxy() throws Exception {
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setSuperclass(Person.class);
        proxyFactory.setHandler(new PersonMethodHandler());
        return proxyFactory.createClass().newInstance();
    }

    // Javassist
    public static void main(String[] args) throws Exception{
        Person person = (Person) createJavassistProxy();
        person.doing();
    }

}
