package com.guang.android.middleware;

import com.guang.android.vo.Bundle;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by Guang on 2017/4/24.
 */

public class MiddlewareManages {

    private IMiddleware[] middlewareList;
    private static MiddlewareManages mSafe = new MiddlewareManages();

    public  void apply(IMiddleware...middewares){
        middlewareList = middewares;
    }

    public static MiddlewareManages getInstance() {
        return mSafe;
    }

    public void start(final Bundle bundle){

        Observable observable = Observable.create(new Observable.OnSubscribe<Bundle>() {
            @Override
            public void call(Subscriber<? super Bundle> subscriber) {
                System.out.println("第一个中间件");

                subscriber.onNext(bundle);
                subscriber.onCompleted();
            }
        });

        for (IMiddleware middleware : middlewareList){
            observable= middleware.apply(observable, bundle);
        }

        observable.subscribe(new Subscriber<Bundle>() {
            @Override
            public void onCompleted() {
                System.out.println("onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("onError" + e.getMessage());
            }

            @Override
            public void onNext(Bundle bundle) {
                System.out.println("end");
                System.out.println("stack length: " + Thread.currentThread().getStackTrace().length);
            }
        });
    }



}
