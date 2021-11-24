package com.restfullApi.rest.webservices.webservicesrestfull.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{
  @Autowired      // here is configuration related to spring boot basic authentication
  public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    auth.inMemoryAuthentication()
        .withUser("zone").password("{noop}mypassword").roles("USER")
        .and()
        .withUser("zone2").password("{noop}mypassword").roles("USER");// those are user name and password
  }
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
        .httpBasic() // it indicate basic authentication is requires
        .and()
        .authorizeRequests()
        .antMatchers("/login", "/h2-console/**").permitAll()
        .anyRequest().authenticated(); // it's indicate all request will be secure
    http.csrf().disable();
    http.headers().frameOptions().disable();
  }
}

