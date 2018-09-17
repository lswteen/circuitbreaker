package com.sunu.circuitbreaker;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import java.net.URI;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by sunu@wemakeprice.com on 2018. 9. 17..
 **/
@Service
public class BookService {
  private final RestTemplate restTemplate;

  public BookService(RestTemplate restTemplate){
    this.restTemplate = restTemplate;
  }

  @HystrixCommand(fallbackMethod = "reliable")
  public String getClinetMethod(){
    URI uri = URI.create("http://localhost:9999/jobs");
    return this.restTemplate.getForObject(uri,String.class);
  }

  public String reliable(){
    return "Cloud Native Java (O'Reilly)";
  }
}
