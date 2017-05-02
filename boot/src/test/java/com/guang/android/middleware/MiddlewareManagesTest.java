package com.guang.android.middleware;

import com.guang.android.vo.Bundle;

/**
 * Created by Guang on 2017/4/24.
 */
public class MiddlewareManagesTest {
    @org.junit.Before
    public void setUp() throws Exception {

    }

    @org.junit.After
    public void tearDown() throws Exception {

    }

    @org.junit.Test
    public void start() throws Exception {

        IMiddleware[] middlewareList = new IMiddleware[30]; // TODO: 2017/4/25 因为部分机型的原因，最大极限值为30

        int k = middlewareList.length;
        while (k--  > 0){
            final int i = k;
            middlewareList[k] = new BaseMiddleware() {
                @Override
                public void call(Bundle bundle) {
                    System.out.println(bundle.setBody(bundle.getBody() + "*").toString() + "： 开始执行");
                }
            };
        }

        MiddlewareManages.getInstance().apply(middlewareList);

        MiddlewareManages.getInstance().start(Bundle.build("http://www.baidu.com?a=123"));
    }

}