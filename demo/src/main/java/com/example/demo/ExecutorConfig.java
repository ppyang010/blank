package com.example.demo;

import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfigChangeListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author ccy
 * @description
 * @time 2020-10-15 13:54
 */
@Configuration
@Slf4j
public class ExecutorConfig {

    @Bean("apolloExecutorService")
    public ThreadPoolExecutor bean() {
        Integer coreSize = SpringUtil.getProperty("apollo.executor.coresize", 1);
        return new ThreadPoolExecutor(coreSize, coreSize,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());
    }


    @ApolloConfigChangeListener(interestedKeyPrefixes = {"apollo.executor."})
    public void onChange(ConfigChangeEvent changeEvent) {
        log.info("change core size");
        ThreadPoolExecutor service = SpringUtil.getBean("apolloExecutorService", ThreadPoolExecutor.class);
        service.setCorePoolSize(SpringUtil.getProperty("apollo.executor.coresize", 1));
    }


}
