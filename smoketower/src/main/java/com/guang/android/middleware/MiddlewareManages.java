package com.guang.android.middleware;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by Guang on 2017/4/24.
 */

public class MiddlewareManages {



    public static void start(){

        List<IMiddeware> arr = new ArrayList<>();

        int k = 1000;
        while (k--  > 0){
            arr.add(new BaseMiddleware() {
                @Override
                public void call() {
                    System.out.println("1");
                }
            });
        }

        Observable prev = Observable.create(new Observable.OnSubscribe<Boolean>() {
            @Override
            public void call(Subscriber<? super Boolean> subscriber) {
                System.out.println("第一个中间件");

                subscriber.onNext(true);
                subscriber.onCompleted();
            }
        });

        for (IMiddeware middeware : arr){
            prev = middeware.apply(prev);
        }

        prev.subscribe(new Subscriber() {
            @Override
            public void onCompleted() {
                System.out.println("onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("onError" + e.getMessage());
            }

            @Override
            public void onNext(Object o) {
                System.out.println("end");
                System.out.println("stack length: " + Thread.currentThread().getStackTrace().length);
            }
        });
    }



}
