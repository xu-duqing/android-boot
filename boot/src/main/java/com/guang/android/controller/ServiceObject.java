package com.guang.android.controller;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Guang on 2017/4/11.
 */

public interface ServiceObject {

    /**
     * 具体执行的服务
     * @param path
     */
    public void invoke(String path);
}
