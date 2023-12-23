package com.ppxytest.webfluxdemo.reactiveStream;

import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;

/**
 * <a href="https://www.bilibili.com/video/BV1r44y1s7wP?p=12&vd_source=0af0380c19af10aa0fe0446f3d3f3f79">b站</a>
 */
public class ReactiveProcessor extends SubmissionPublisher<String> implements Flow.Processor<String, String> {

    private Flow.Subscription subscription;

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        System.out.println("Processor建立订阅关系");
        this.subscription = subscription;
        this.subscription.request(1);
    }

    @Override
    public void onNext(String item) {
        System.out.println("Processor接收数据:" + item);
        //中间处理
        this.submit(item.toUpperCase());//数据转发给最终订阅者
        //背压实现的核心
        this.subscription.request(1);
    }

    @Override
    public void onError(Throwable throwable) {

    }

    @Override
    public void onComplete() {

    }
}
