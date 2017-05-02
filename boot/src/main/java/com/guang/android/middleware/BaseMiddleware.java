package com.guang.android.middleware;

import com.guang.android.vo.Bundle;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;

/**
 * Created by Guang on 2017/4/25.
 */

public abstract class BaseMiddleware implements IMiddleware {

    public Observable apply(final Observable observable) {
        return observable.flatMap(new Func1<Bundle,Observable>() {
            @Override
            public Observable call(final Bundle bundle) {
                return Observable.create(new Observable.OnSubscribe<Bundle>() {
                    @Override
                    public void call(Subscriber<? super Bundle> subscriber) {

                        BaseMiddleware.this.call(bundle);

                        subscriber.onNext(bundle);
                        subscriber.onCompleted();
                    }
                });
            }
        });
    }
}
