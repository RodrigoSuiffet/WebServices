package com.in28minutes.rest.webservices.webservicesrestfull.helloworld;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

  //@RequestMapping(method= RequestMethod.GET,path = "/hello-world")
  @GetMapping (path = "/hello-world")
  public String helloWorld() {
    return "Hello World";
  }

  @GetMapping (path = "/hello-world/varpath/{name}")
  public helloWorldBean helloWorldBean(@PathVariable String name) {
    return new helloWorldBean(String.format("Hello World, %s",name));
  }


}
