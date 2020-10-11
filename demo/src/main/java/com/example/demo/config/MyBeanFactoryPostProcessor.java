package com.example.demo.config;

import com.example.demo.resolver.MyStringValueResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Slf4j
@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor, EnvironmentAware {

    private StandardEnvironment environment;
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
//        beanFactory.addEmbeddedValueResolver(new MyStringValueResolver());
//        HashMap<String, Object> map = new HashMap<>();
//        map.put("example.data","MyBeanFactoryPostProcessor value");
//        environment.getPropertySources().addFirst(new MyPropertySource("MyBeanFactoryPostProcessor",map));
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment= (StandardEnvironment) environment;
    }
}
