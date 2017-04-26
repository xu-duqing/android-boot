package com.guang.android.middleware;

import com.guang.android.vo.Bundle;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;

/**
 * Created by Guang on 2017/4/25.
 */

public abstract class BaseMiddleware implements IMiddleware {

    public Observable apply(final Observable observable,final Bundle bundle) {
        return Observable.create(new Observable.OnSubscribe<Boolean>() {

            @Override
            public void call(Subscriber<? super Boolean> subscriber) {

                BaseMiddleware.this.call(bundle);

                subscriber.onNext(true);
                subscriber.onCompleted();
            }
        }).flatMap(new Func1<Boolean, Observable<?>>() {
            @Override
            public Observable<?> call(Boolean aBoolean) {
                return observable;
            }
        });
    }
}
