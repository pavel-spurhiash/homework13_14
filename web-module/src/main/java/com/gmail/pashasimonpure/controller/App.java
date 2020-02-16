package com.gmail.pashasimonpure.controller;

import java.lang.invoke.MethodHandles;

import com.gmail.pashasimonpure.controller.config.AppConfig;
import com.gmail.pashasimonpure.controller.constant.FileConstant;
import com.gmail.pashasimonpure.service.FileService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

    private static final Logger logger = LogManager.getLogger(MethodHandles.lookup().lookupClass());

    public static void main(String[] args) {

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(AppConfig.class);
        ctx.refresh();

        FileConstant fileConstant = ctx.getBean(FileConstant.class);
        FileService fileService = ctx.getBean(FileService.class);

        logger.info("TOTAL SUM = " + fileService.getValue(fileConstant.testFilePath));

    }

}