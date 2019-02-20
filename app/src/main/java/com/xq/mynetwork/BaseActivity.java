package com.xq.mynetwork;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.xq.mylibrary.listener.NetChangeObserver;
import com.xq.mylibrary.type.NetType;
import com.xq.mylibrary.utils.NetWorkManager;

public abstract class BaseActivity extends AppCompatActivity implements NetChangeObserver {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        NetWorkManager.getInstance().init(getApplication());
        NetWorkManager.getInstance().setListener(this);
    }

    @Override
    public void onConnect(NetType netType) {
        onNetConnect(netType);
    }

    @Override
    public void onDisConnect() {
        onNetDisConnect();
    }

    protected abstract void onNetConnect(NetType netType);

    protected abstract void onNetDisConnect();
}
