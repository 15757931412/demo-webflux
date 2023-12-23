package com.ppxytest.webfluxdemo.reactor;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * <a href="https://www.bilibili.com/video/BV1r44y1s7wP?p=12&vd_source=0af0380c19af10aa0fe0446f3d3f3f79">b站</a>
 */
public class ReactorDemo3 {
    /**
     * 输入：hello guys i am bole welcome to normal school jdk quick fox prizev
     * 输出 abcdefghijklmnopqrstuvwxyz
     */
    public static void main(String[] args) {
        String src = "hello guys i am bole welcome to normal school jdk quick fox prizev";
        Flux.fromArray(src.split(" ")).flatMap(i -> Flux.fromArray(i.split("")))
                .distinct()
                .sort()
                .subscribe(System.out::print);
    }

}



