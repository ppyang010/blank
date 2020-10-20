package com.example.demo;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class SpringUtil implements EnvironmentAware, ApplicationContextAware {

    private static ConfigurableEnvironment environment;
    private static ApplicationContext applicationContext;

    @Override
    public void setEnvironment(Environment environment) {
        SpringUtil.environment = (ConfigurableEnvironment) environment;
    }

    public static ConfigurableEnvironment getEnvironment() {
        return environment;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringUtil.applicationContext = applicationContext;
    }

    public static <T> T getBean(Class<T> clazz) {
        return applicationContext.getBean(clazz);
    }

    public static <T> T getBean(String name, Class<T> clazz) {
        return applicationContext.getBean(name, clazz);
    }

    public static Integer getProperty(String key, Integer defaultValue) {
        return applicationContext.getEnvironment().getProperty(key, Integer.class, defaultValue);
    }
    public static String getProperty(String key, String defaultValue) {
        return applicationContext.getEnvironment().getProperty(key, String.class, defaultValue);
    }
}
