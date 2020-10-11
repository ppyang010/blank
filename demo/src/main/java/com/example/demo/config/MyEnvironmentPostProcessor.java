package com.example.demo.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.HashMap;

@Slf4j
public class MyEnvironmentPostProcessor implements EnvironmentPostProcessor {
    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        log.info("MyEnvironmentPostProcessor");
//        HashMap<String, Object> map = new HashMap<>();
//        map.put("example.data", "MyEnvironmentPostProcessor value");
//        environment.getPropertySources().addFirst(new MyPropertySource("MyEnvironmentPostProcessor", map));
    }
}
