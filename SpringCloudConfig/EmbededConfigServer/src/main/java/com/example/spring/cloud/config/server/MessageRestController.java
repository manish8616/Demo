package com.example.spring.cloud.config.server;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class MessageRestController {

  @Value("${hello_word:Hello default}")
  private String message;

  @RequestMapping("/")
  String getMessage() {
    return this.message;
  }
}
