package com.ppxytest.webfluxdemo.reactiveStream;

import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;

public class ReactiveStreamDemo {
    public static void main(String[] args) throws InterruptedException {
        //1.创建一个发布者
        SubmissionPublisher<Object> publisher = new SubmissionPublisher<>();
        //2.创建一个订阅者
        Flow.Subscriber<Object> subscriber = new Flow.Subscriber<>() {

            Flow.Subscription subscription;

            @Override
            public void onSubscribe(Flow.Subscription subscription) {
                System.out.println("建立订阅关系");
                this.subscription = subscription;
                subscription.request(1);//第一次需要
            }

            @Override
            public void onNext(Object item) {
                System.out.println("接收数据:" + item);
                // 业务处理
                subscription.request(10);//背压
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("发生错误了");
            }

            @Override
            public void onComplete() {
                System.out.println("数据接收完成");
            }
        };

        //3.建立订阅关系
        publisher.subscribe(subscriber);

        //4.发送数据
        for (int i = 0; i < 100; i++) {
            publisher.submit("hello reactive stream" + i);
        }

        Thread.sleep(10000);
    }
}
