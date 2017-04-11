package com.guang.android;

/**
 * Created by Guang on 2017/4/10.
 */

public class Boot {

    private static Boot mSafe = new Boot();

    private Boot(){}

    public static Boot getInstance() {
        return mSafe;
    }

    public static void start(String url){

    }
}
