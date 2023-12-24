package com.ppxytest.webfluxdemo.reactor;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.util.stream.Stream;

public class C01ThreadModel {
    public static void main(String[] args) throws InterruptedException {
        Flux.fromStream(() -> {
                    System.out.printf("Producing stream in thread %s%n", Thread.currentThread().getName());
                    return Stream.of("max", "jack", "kate", "bill", "joe");
                }).map(n -> {
                    System.out.printf("#1 Mapping %s in thread %s%n", n, Thread.currentThread().getName());
                    return n.toUpperCase();
                })
                .publishOn(Schedulers.boundedElastic())
                .map(n -> {
                    System.out.printf("#2 Mapping %s in thread %s%n", n, Thread.currentThread().getName());
                    Thread.currentThread().getName();
                    return n + "_X";
                })
                .doOnNext(n -> {
                    System.out.printf("doOnNext %s in thread %s%n", n, Thread.currentThread().getName());
                })
                .parallel()
                .runOn(Schedulers.parallel()).subscribe();

//                .subscribeOn(Schedulers.boundedElastic())
//                .subscribe();
        Thread.sleep(1000);
    }
}
