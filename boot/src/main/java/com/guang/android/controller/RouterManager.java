package com.guang.android.controller;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Guang on 2017/4/11.
 */

public class RouterManager {

    private Map<String,ServiceObject> mServiceMap = new HashMap<>();

    public void regist(String host, ServiceObject service){
        mServiceMap.put(host, service);
    }

    public void invoke(URI url){
        ServiceObject service = mServiceMap.get(url.getHost());
        service.invoke(url.getPath());
    }
}
