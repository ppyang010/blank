package com.example.demo;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import com.example.demo.domain.ApolloTestBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

@SpringBootApplication
@EnableApolloConfig
@Slf4j
@EnableConfigurationProperties({ApolloTestBean.class})
public class DemoApplication {

    @Autowired
    private ApolloTestBean apolloTestBean;

    public static void main(String[] args) {

        SpringApplication springApplication = new SpringApplication(DemoApplication.class);
        springApplication.setAdditionalProfiles("dev");
        ConfigurableApplicationContext context = springApplication.run(args);
        ConfigurableEnvironment environment = context.getEnvironment();
        System.out.println(environment.getClass().getName());

    }


}
