package com.example.elkservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;

@RestController
@Slf4j
public class ELKController {
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @RequestMapping(value = "/elk")
    public String helloWorld() {
        String response = "Welcome to JavaInUse" + new Date();
        log.info(response);

        return response;
    }

    @RequestMapping(value = "/exception")
    public String exception() {
        String response = "";
        try {
            throw new Exception("Exception has occured....");
        } catch (Exception e) {
            e.printStackTrace();
            log.error(String.valueOf(e));

            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            String stackTrace = sw.toString();
            log.error("Exception - " + stackTrace);
            response = stackTrace;
        }

        return response;
    }
}
