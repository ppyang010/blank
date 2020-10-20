package com.example.demo.listener;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;

public class ApplicationReadyEventListener implements ApplicationListener<ApplicationReadyEvent> {
 
  @Override
  public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
    System.out.println("============>>>>> applicationReadyEvent is trigged");
  }
}