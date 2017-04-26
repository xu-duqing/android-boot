package com.guang.android.android_boot;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.guang.android.middleware.MiddlewareManages;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void onClick(View view){
        MiddlewareManages.getInstance().start(new com.guang.android.vo.Bundle());
    }
}
