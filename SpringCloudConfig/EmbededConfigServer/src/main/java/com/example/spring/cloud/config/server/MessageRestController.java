package com.example.spring.cloud.config.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RefreshScope
@RestController
public class MessageRestController {
  @Value("${demo_hello_word:demo_hello_word}")
  private String demoMsg;
  
  @Value("${core_hello_word:core_hello_word}")
  private String coreMsg;
  @Value("${entitlement_hello_word:entitlement_hello_word}")
  private String entitlemenMsg;
  
  
  private static Logger log = LoggerFactory.getLogger(MessageRestController.class);

  @RequestMapping("/")
  String getMessage() {
	  log.info("Inside MessageRestController getMessage");
	 
	  String m = this.demoMsg +" , "+this.entitlemenMsg +" ,"+this.coreMsg;
    return m;
  }
}
