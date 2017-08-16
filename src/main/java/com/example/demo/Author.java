package com.example.demo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


/**
 * @Version
 * @Title: Author
 * @Package: package com.example.demo
 * @Description:
 * @Author: WenJie
 * @Date: 2017/8/8
 */
@Component
@ConfigurationProperties(prefix = "author")
public class Author {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
