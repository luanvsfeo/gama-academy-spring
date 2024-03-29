package com.gama.ecommerce.autenticacao.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(HttpMethod.POST, "/usuario", "/produto", "/marca", "/categoria").authenticated()
                .antMatchers(HttpMethod.GET, "/usuario", "/produto/**", "/marca/**", "/categoria/**").permitAll()
                .antMatchers(HttpMethod.DELETE, "/usuario", "/produto/**", "/marca/**", "/categoria/**").authenticated()
                .antMatchers(HttpMethod.PUT, "/usuario", "/produto/**", "/marca/**", "/categoria/**").authenticated();
    }
}