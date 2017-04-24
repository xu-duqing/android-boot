package com.guang.android.middleware;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by Guang on 2017/4/24.
 */

public class MiddlewareManages {

    static List<IMiddeware> arr = new ArrayList<>();


    public static void start(){

        arr.add(new BaseMiddleware() {
            @Override
            public void call() {
                System.out.println("1");
            }
        });

        arr.add(new BaseMiddleware() {
            @Override
            public void call() {
                System.out.println("2");
            }
        });

        arr.add(new BaseMiddleware() {
            @Override
            public void call() {
                System.out.println("3");
            }
        });

        arr.add(new BaseMiddleware() {
            @Override
            public void call() {
                System.out.println("4");
            }
        });

        arr.add(new BaseMiddleware() {
            @Override
            public void call() {
                System.out.println("5");
            }
        });

        arr.add(new BaseMiddleware() {
            @Override
            public void call() {
                System.out.println("6");
            }
        });


        int i = arr.size();

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
            }
        });
    }



}
