package com.ppxytest.webfluxdemo.reactor;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.stream.Stream;

public class ReactorDemo {

    public static void main(String[] args) {
        //mono创建方式
//        Mono.empty().subscribe(System.out::println);
//        Mono.just("hello mono").subscribe(System.out::println);

        //Flux创建方式 0-n 元素序列
//        Flux.just(1, 2, 3, 4, 5, 6).subscribe(System.out::println);
//        Flux.fromIterable(Arrays.asList("a", "b", "c", "d", "e")).subscribe(System.out::println);
//        Flux.fromArray(new String[]{"a", "b", "c", "d", "e"}).subscribe(System.out::println);
//        Flux.fromStream(Stream.of(1,2,3,4,5,6,7,8)).subscribe(System.out::println);
//        Flux.range(1, 100).subscribe(System.out::println);

        /**
         * 案例:
         * 2*0=0
         * 2*1=2
         * ...
         * 2*9=18
         */
//        Flux.generate(() -> 0, (i, sink) -> {
//            sink.next("2*" + i + "=" + 2 * i);
//            if (i == 9) sink.complete();
//            return ++i;
//        }).subscribe(System.out::println);

        Flux.just(1, 2, 3, 4, 5, 6, 7, 8)
                .buffer(2,3).subscribe(System.out::print);
        System.out.println("--------------------");
        Flux.just(1, 2, 3, 4, 5, 6, 7, 8).subscribe(System.out::print);

    }

}
