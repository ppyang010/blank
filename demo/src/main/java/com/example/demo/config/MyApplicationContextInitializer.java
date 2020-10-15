package com.example.demo.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.HashMap;

@Slf4j
public class MyApplicationContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        log.info("MyApplicationContextInitializer initialize");
        HashMap<String, Object> map = new HashMap<>();
        map.put("example.data","MyApplicationContextInitializer value");
        applicationContext.getEnvironment().getPropertySources()
                .addFirst(new MyPropertySource("MyApplicationContextInitializer", map));
    }
}
