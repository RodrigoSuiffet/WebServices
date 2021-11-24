package com.restfullApi.rest.webservices.webservicesrestfull.user.controller.filtering;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {

  @GetMapping ("/filtering")
  public SomeBean retrieveSomeBean(){
    return new SomeBean("usuario","password","loquesea");
  }
  @GetMapping ("/filtering2")
  public SomeBean2 retrieveSomeBean2(){
    return new SomeBean2("usuario","password","loquesea");
  }

  //Este devolverá usuario y password
  @GetMapping ("/dynamicfiltering")
  public MappingJacksonValue retrieveSomeDynamicBean(){
    SomeDynamicBean someDynamicBean = new SomeDynamicBean("usuario","password","loquesea");
    MappingJacksonValue mapping = filtrar("usuario","password",someDynamicBean);
    return mapping;
  }
  //este devolverá usuario y value3
  @GetMapping ("/dynamicfiltering2")
  public MappingJacksonValue retrieveSomeDynamicBean2(){
    SomeDynamicBean someDynamicBean = new SomeDynamicBean("usuario","password","loquesea");
    return filtrar("usuario","value3",someDynamicBean);
  }

  private MappingJacksonValue filtrar (String campo1,String campo2,SomeDynamicBean someDynamicBean) {
    SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.
        filterOutAllExcept(campo1,campo2);

    FilterProvider filters = new SimpleFilterProvider().
        addFilter("SomeDynamicBeanFilter",filter);

    MappingJacksonValue mapping = new MappingJacksonValue(someDynamicBean);
    mapping.setFilters(filters);
    return mapping;
  }

}
