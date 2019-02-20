package com.xq.mylibrary.utils;

import android.app.Application;
import android.content.IntentFilter;

import com.xq.mylibrary.NetWorkStateReceiver;
import com.xq.mylibrary.listener.NetChangeObserver;


public class NetWorkManager {

    private static volatile NetWorkManager instance;
    private Application application;
    private NetWorkStateReceiver receiver;

    private NetWorkManager() {
        receiver = new NetWorkStateReceiver();
    }

    public static NetWorkManager getInstance() {
        if (instance == null) {
            synchronized (NetWorkManager.class) {
                if (instance == null) {
                    instance = new NetWorkManager();
                }
            }
        }
        return instance;
    }

    public Application getApplication() {
        if (application == null) {
            throw new RuntimeException("NetWorkManager.getInstance().init()未初始化");
        }
        return application;
    }

    public void init(Application application) {
        this.application = application;

        //广播注册
        IntentFilter filter = new IntentFilter();
        filter.addAction(Constants.ANDROID_NET_CHANGE_ACTION);
        application.registerReceiver(receiver, filter);
    }

    public void setListener(NetChangeObserver listener) {
        receiver.setListener(listener);
    }
}
