package com.demo.core.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "demo.security")
@Data
public class SecurityProperties {
    private BrowserProperties browser= new BrowserProperties();

}
