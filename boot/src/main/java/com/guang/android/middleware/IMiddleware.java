package com.guang.android.middleware;

import com.guang.android.vo.Bundle;

import rx.Observable;


/**
 * Created by Guang on 2017/4/25.
 */

public interface IMiddleware {

    public void call(Bundle bundle);

    public Observable apply(Observable observable);
}
