package com.guang.android.middleware;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by Guang on 2017/4/24.
 */

public class MiddlewareManages {

    static List<Options> arr = new ArrayList<>();


    public static void start(){

        arr.add(new Options(1));
        arr.add(new Options(2));
        arr.add(new Options(3));
        arr.add(new Options(4));
        arr.add(new Options(5));
        arr.add(new Options(6));


        int i = arr.size();

        Observable prev = Observable.create(new Observable.OnSubscribe<Boolean>() {
            @Override
            public void call(Subscriber<? super Boolean> subscriber) {
                System.out.println("第一个中间件");

                subscriber.onNext(true);
                subscriber.onCompleted();
            }
        });

        for (Options option : arr){
            prev = option.apply(prev);
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
