package com.example.demo.controller;

import com.example.demo.domain.ApolloTestBean;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestApolloController {

    @Value("${apollo.data.param1:}")
    private String param1;
    @Autowired
    private ApolloTestBean apolloTestBean;


    @GetMapping("/test/apollo")
    public String param(){
        return param1;
    }

    @GetMapping("/test/apollo/apolloTestBean")
    public String apolloTestBean(){
        return apolloTestBean.toString();
    }
}
