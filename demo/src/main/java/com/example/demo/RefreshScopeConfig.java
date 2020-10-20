package com.example.demo;

import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfigChangeListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

/**
 * @author ccy
 * @description
 * @time 2020-10-15 14:46
 */
@Configuration
@Slf4j
public class RefreshScopeConfig {
//    @Autowired
//    private RefreshScope refreshScope;
//
//    @ApolloConfigChangeListener(interestedKeyPrefixes = {"apollo.data."})
//    public void onChange(ConfigChangeEvent changeEvent) {
//        log.info("before refresh {}", apolloTestBean.toString());
//        refreshScope.refresh("apolloTestBean");
//        log.info("after refresh {}", apolloTestBean.toString());
//    }
}
