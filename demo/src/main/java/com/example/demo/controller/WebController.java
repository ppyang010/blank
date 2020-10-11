package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {
    @Value("${example.data}")
    private String data;
    @Value("${example.str}")
    private String str;

    @Value("${example.beetl.result}")
    private String beetlStr;

    @Autowired
    private Environment environment;

    @GetMapping("/example/data")
    public String data() {
        return data;
    }

    @GetMapping("/example/str")
    public String str() {
        System.out.println(environment.getProperty("example.str"));
        return str;
    }

    @GetMapping("/example/beetlStr")
    public String beetlStr() {
        return beetlStr;
    }

    @GetMapping("/example/password")
    public String password() {
        System.out.println(environment.getProperty("example.password"));
        return str;
    }
}
