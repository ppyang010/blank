package com.example.demo;

import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfigChangeListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.logging.LogLevel;
import org.springframework.boot.logging.LoggingSystem;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import java.util.Set;

@Configuration
@Slf4j
public class LoggingLevelRefresher {

    private static final String PREFIX = "logging.level.";
    private static final String ROOT = LoggingSystem.ROOT_LOGGER_NAME;
    private static final String SPLIT = ".";

    @Resource
    private LoggingSystem loggingSystem;


    @ApolloConfigChangeListener(interestedKeyPrefixes = PREFIX)
    private void onChange(ConfigChangeEvent changeEvent) {
        refreshLoggingLevels(changeEvent.changedKeys());
        log.info("LoggingLevelRefresher");
        log.debug("LoggingLevelRefresher");
    }

    private void refreshLoggingLevels(Set<String> changedKeys) {
        for (String key : changedKeys) {
            // key may be : logging.level.com.example.web
            if (key.startsWith(PREFIX)) {
                String loggerName = PREFIX.equalsIgnoreCase(key) ? ROOT : key.substring(PREFIX.length());
                String value = SpringUtil.getProperty(key, "info");
                LogLevel level = LogLevel.valueOf(value.toUpperCase());
                loggingSystem.setLogLevel(loggerName, level);

            }
        }
    }


}