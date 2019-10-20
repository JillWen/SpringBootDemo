package com.demo.core.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class AbstractChannelSecurityConfig extends WebSecurityConfigurerAdapter {
//    @Autowired
//    protected AuthenticationSuccessHandler imoocAuthenticationSuccessHandler;
//
//    @Autowired
//    protected AuthenticationFailureHandler imoocAuthenticationFailureHandler;

    protected void applyPasswordAuthenticationConfig(HttpSecurity http) throws Exception {
//        http.formLogin()
//                .loginPage("/authentication/require")
//                .loginProcessingUrl("/authentication/form")
//                .successHandler(imoocAuthenticationSuccessHandler)
//                .failureHandler(imoocAuthenticationFailureHandler)
        ;
    }
}
