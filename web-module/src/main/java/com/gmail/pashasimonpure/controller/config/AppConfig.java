package com.gmail.pashasimonpure.controller.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:config.properties")
@ComponentScan(basePackages = {
        "com.gmail.pashasimonpure.repository",
        "com.gmail.pashasimonpure.service",
        "com.gmail.pashasimonpure.controller"})

public class AppConfig {

}