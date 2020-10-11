package com.example.demo;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class SpringUtil implements EnvironmentAware {

    private static ConfigurableEnvironment environment;
    @Override
    public void setEnvironment(Environment environment) {
        SpringUtil.environment = (ConfigurableEnvironment) environment;
    }
    public static ConfigurableEnvironment getEnvironment(){
        return environment;
    }

}
