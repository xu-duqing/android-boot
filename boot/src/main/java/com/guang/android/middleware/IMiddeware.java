package com.guang.android.middleware;

import rx.Observable;

/**
 * Created by Guang on 2017/4/25.
 */

public interface IMiddeware {

    public void call();

    public Observable apply(Observable observable);
}
