package com.demo.security.browser.config;

import com.demo.core.config.AbstractChannelSecurityConfig;
import com.demo.core.properties.SecurityConstants;
import com.demo.core.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class BrowserSecurityConfig extends AbstractChannelSecurityConfig {
    @Autowired
    private SecurityProperties securityProperties;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .loginPage(SecurityConstants.DEFAULT_AUTHENTICATION_REQUIRED_URL)
                .loginProcessingUrl("/authentication/form")
                .usernameParameter("user")
                .passwordParameter("pwd")
                .and()
                .authorizeRequests()
                .antMatchers(SecurityConstants.DEFAULT_AUTHENTICATION_REQUIRED_URL, securityProperties.getBrowser().getLoginPage()).permitAll()
                .anyRequest()
                .authenticated()
                .and().csrf().disable();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
