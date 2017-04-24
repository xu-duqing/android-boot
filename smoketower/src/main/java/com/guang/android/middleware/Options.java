package com.guang.android.middleware;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;

/**
 * Created by Guang on 2017/4/24.
 */

public class Options {

    final int id;

    public Options(int id){
        this.id = id;
    }

    public Observable apply(final Observable observable) {
        return Observable.create(new Observable.OnSubscribe<Boolean>() {

            @Override
            public void call(Subscriber<? super Boolean> subscriber) {
                System.out.println("s123" + id);

                subscriber.onNext(true);
                subscriber.onCompleted();
            }
        }).flatMap(new Func1<Boolean, Observable<Boolean>>() {
            @Override
            public Observable<Boolean> call(final Boolean aBoolean) {
                return observable;
            }
        });
    }
}
