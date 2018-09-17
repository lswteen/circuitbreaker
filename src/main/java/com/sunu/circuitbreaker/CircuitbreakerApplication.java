package com.sunu.circuitbreaker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@EnableCircuitBreaker
@RestController
@SpringBootApplication
public class CircuitbreakerApplication {

  @Autowired
  private BookService bookService;

  @Bean
  public RestTemplate rest(RestTemplateBuilder builder) {
    return builder.build();
  }

  @GetMapping("/toService")
  public String getServiceStatus(){
    return bookService.getClinetMethod();
  }

  public static void main(String[] args) {
    SpringApplication.run(CircuitbreakerApplication.class, args);
  }
}
