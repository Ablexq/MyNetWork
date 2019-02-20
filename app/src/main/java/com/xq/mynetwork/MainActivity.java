package com.xq.mynetwork;

import android.os.Bundle;

import com.xq.mylibrary.type.NetType;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onNetConnect(NetType netType) {
        System.out.println("连接了==========" + netType.name());
    }

    @Override
    protected void onNetDisConnect() {
        System.out.println("断开了============");
    }
}
