package com.restfullApi.rest.webservices.webservicesrestfull.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningController {

  //opt1: Diferentes endpoints dependiendo de la version
  @GetMapping ("/person/v1")
  public PersonV1 personV1 (){
    return new PersonV1("Rod Sui");
  }

  @GetMapping ("/person/v2")
  public PersonV2 personV2 (){
    return new PersonV2(new Name("Rod","Sui"));
  }

  //opt2 por parámetro
  @GetMapping (value="/person/param", params="version=1")
  public PersonV1 paramV1 (){
    return new PersonV1("Rod Sui");
  }

  @GetMapping (value="/person/param", params="version=2")
  public PersonV2 paramV2 (){
    return new PersonV2(new Name("Rod","Sui"));
  }

  //opt3 por propiedad en el header
  @GetMapping (value="/person/header", headers="X-API-VERSION=1")
  public PersonV1 headerV1 (){
    return new PersonV1("Rod Sui");
  }

  @GetMapping (value="/person/header", headers="X-API-VERSION=2")
  public PersonV2 headerV2 (){
    return new PersonV2(new Name("Rod","Sui"));
  }

  //opt4 produces: En header parámetro Accept
  @GetMapping (value="/person/produces", produces="application/vnd.company.app-v1+json")
  public PersonV1 producesV1 (){
    return new PersonV1("Rod Sui");
  }

  @GetMapping (value="/person/produces", produces="application/vnd.company.app-v2+json")
  public PersonV2 producesV2 (){
    return new PersonV2(new Name("Rod","Sui"));
  }


}
