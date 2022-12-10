package com.cloudcomputing.backend.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "")
public class Test {
  @GetMapping("/test")
  public String TestFunction() {
    return "Something";
  }
}
