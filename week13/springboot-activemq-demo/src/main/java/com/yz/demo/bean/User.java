package com.yz.demo.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * User
 * version: 1.0
 */
@Setter
@Getter
@ToString
public class User implements Serializable {

    private int age;

    private String name;
}
