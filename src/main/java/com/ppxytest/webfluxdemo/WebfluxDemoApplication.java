package com.ppxytest.webfluxdemo;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;

@SpringBootApplication
@OpenAPIDefinition
public class WebfluxDemoApplication {

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(WebfluxDemoApplication.class, args);
    }

}
