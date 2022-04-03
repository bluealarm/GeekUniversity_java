package com.example.aopdemo.proxy.saop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PersonController {

    @Autowired
    com.example.aopdemo.proxy.saop.PersonServiceImpl personService;

    @GetMapping("/test")
    public void test(){
        personService.doing();
    }
}
