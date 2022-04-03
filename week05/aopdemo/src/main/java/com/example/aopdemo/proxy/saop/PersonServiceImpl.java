package com.example.aopdemo.proxy.saop;

import com.example.aopdemo.proxy.saop.CustomAspectJAnn;
import com.example.aopdemo.proxy.statics.Person;
import org.springframework.stereotype.Component;


@Component
public class PersonServiceImpl {

    /**
     * AspectJ
     */
    @CustomAspectJAnn(cacheExpire = 60)
    public void doing() {
        Person person = new Person();
        person.doing();
    }
}
