package com.guang.android.controller;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Guang on 2017/4/11.
 */

public class RouterManager {
    
    private static RouterManager mSafe = new RouterManager();

    public static RouterManager getInstance() {
        return mSafe;
    }

    private Map<String,ServiceObject> mServiceMap = new HashMap<>();

    public void regist(String host, ServiceObject service){
        mServiceMap.put(host, service);
    }

    public ServiceObject getService(String url){
        return mServiceMap.get(url);
    }
}
