package com.example.demo;

import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfigChangeListener;
import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import com.example.demo.domain.ApolloTestBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.context.scope.refresh.RefreshScope;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

@SpringBootApplication
@EnableApolloConfig
@Slf4j
@EnableConfigurationProperties({ApolloTestBean.class})
public class DemoApplication {
    @Autowired
    private RefreshScope refreshScope;
    @Autowired
    private ApolloTestBean apolloTestBean;

    public static void main(String[] args) {

        SpringApplication springApplication = new SpringApplication();
        ConfigurableApplicationContext context = springApplication.run(DemoApplication.class, args);
        ConfigurableEnvironment environment = context.getEnvironment();
        environment.getProperty("x");
        System.out.println(environment.getClass().getName());

    }


    @ApolloConfigChangeListener(interestedKeyPrefixes = {"apollo.data."})
    public void onChange(ConfigChangeEvent changeEvent) {
        log.info("before refresh {}", apolloTestBean.toString());
        refreshScope.refresh("apolloTestBean");
        log.info("after refresh {}", apolloTestBean.toString());
    }

}
