package com.guang.android.middleware;

import android.content.Intent;

import com.guang.android.controller.RouterManager;
import com.guang.android.vo.Bundle;

/**
 * Created by Guang on 2017/4/26.
 */

public class Middlewares {

    public class FindMathodMiddleware extends BaseMiddleware{

        @Override
        public void call(Bundle bundle) {
            bundle.serviceObject = RouterManager.getInstance().getService(bundle.url);
        }
    }

    public class OpenActivityMiddleware extends BaseMiddleware{

        @Override
        public void call(Bundle bundle) {
            if (bundle.returnObject != null
                    && bundle.returnObject.getClass().equals(Intent.class)
                    && bundle.context != null){

                bundle.context.startActivity((Intent) bundle.returnObject);
            }
        }
    }
}
