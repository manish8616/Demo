package com.example.spring.cloud.config.server;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConfigurationServiceApplication {
	  private static Logger log = LoggerFactory.getLogger(ConfigurationServiceApplication.class);
  public static void main(String[] args) {
    SpringApplication.run(ConfigurationServiceApplication.class, args);
  }
  
  
}
