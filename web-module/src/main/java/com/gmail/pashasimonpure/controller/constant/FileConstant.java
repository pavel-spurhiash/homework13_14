package com.gmail.pashasimonpure.controller.constant;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class FileConstant {

    @Autowired
    private Environment environment;

    public String testFilePath;

    @PostConstruct
    private void init() {

        this.testFilePath = environment.getProperty("file.path");

    }

}