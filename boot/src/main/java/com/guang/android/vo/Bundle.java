package com.guang.android.vo;

import android.content.Context;

import com.guang.android.controller.ServiceObject;

/**
 * Created by Guang on 2017/4/11.
 */

public class Bundle {
    public String url;
    public String body;
    public Context context;
    public Object returnObject;
    public ServiceObject serviceObject;

    public static Bundle build(String url){
        Bundle bundle = new Bundle();
        bundle.url = url;
        return bundle;
    }

    public Bundle setBody(String body){
        this.body = body;
        return this;
    }



    public String getBody() {
        return body;
    }

    @Override
    public String toString() {
        return "Bundle{" +
                "url='" + url + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
