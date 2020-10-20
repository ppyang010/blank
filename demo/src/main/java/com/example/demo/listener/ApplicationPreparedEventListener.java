package com.example.demo.listener;

import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.context.ApplicationListener;

public class ApplicationPreparedEventListener implements ApplicationListener<ApplicationPreparedEvent> {
 
  @Override
  public void onApplicationEvent(ApplicationPreparedEvent applicationPreparedEvent) {
    System.out.println("============>>>>> applicationPreparedEvent is trigged");
  }
}