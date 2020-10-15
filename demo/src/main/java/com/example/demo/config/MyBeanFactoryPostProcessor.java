package com.example.demo.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.Ordered;
import org.springframework.core.PriorityOrdered;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySource;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor, EnvironmentAware, PriorityOrdered {

    public static final String COMMAND_LINE_ARGS = "commandLineArgs";
    private ConfigurableEnvironment environment;

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        //将commandLine数据源移动到最前面
        ensureCommandLinePropertyPrecedence(environment);
    }

    private void ensureCommandLinePropertyPrecedence(ConfigurableEnvironment environment) {
        MutablePropertySources propertySources = environment.getPropertySources();

        PropertySource<?> propertySource = propertySources
                .get(COMMAND_LINE_ARGS);

        // not exists or already in the first place
        //不存在或已经在最前面
        if (propertySource == null || propertySources.precedenceOf(propertySource) == 0) {
            return;
        }

        propertySources.remove(COMMAND_LINE_ARGS);
        propertySources.addFirst(propertySource);
    }

    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE;//优先级最低
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = (ConfigurableEnvironment) environment;
    }



}
