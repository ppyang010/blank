package com.example.demo.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author ccy
 * @description
 * @time 2020-10-30 10:36
 */
@Slf4j
@Component
public class MyCommandLineRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        log.info("MyCommandLineRunner run");
    }
}
