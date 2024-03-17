package com.example.springclientslistpractise;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@ComponentScan("com.example.springclientslistpractise")
@PropertySource("classpath:application.properties")
public class AppConfig {
    @Value("${spring.profiles.active:}")
    String profile;

    public String getProfile() {
        return profile;
    }

}
