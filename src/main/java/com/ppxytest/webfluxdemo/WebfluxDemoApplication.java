package com.ppxytest.webfluxdemo;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.ArrayList;

@SpringBootApplication
@OpenAPIDefinition
public class WebfluxDemoApplication {

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(WebfluxDemoApplication.class, args);
    }

    //2.函数编程
    @Bean
    public RouterFunction<ServerResponse> routes() {
        return RouterFunctions.route()
                .GET("/func/greeting", request -> ServerResponse.ok()
                        .bodyValue("hello webflux by function"))
                .build();

    }

}


@RestController
@RequestMapping("/annotated")
class WebfluxController {

    @GetMapping("/greeting")
    public Mono<String> greeting() {
        return Mono.just("hello webflux by annotated");
    }
}