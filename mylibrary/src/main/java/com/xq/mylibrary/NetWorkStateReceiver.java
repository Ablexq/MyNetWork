package com.xq.mylibrary;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.xq.mylibrary.listener.NetChangeObserver;
import com.xq.mylibrary.type.NetType;
import com.xq.mylibrary.utils.Constants;
import com.xq.mylibrary.utils.NetWorkUtil;

public class NetWorkStateReceiver extends BroadcastReceiver {


    private static final String TAG = NetWorkStateReceiver.class.getName();
    private NetType netType;
    private NetChangeObserver listener;

    public NetWorkStateReceiver() {
        this.netType = NetType.NONE;
    }

    public void setListener(NetChangeObserver listener) {
        this.listener = listener;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent == null || intent.getAction() == null) {
            return;
        }

        if (intent.getAction().equalsIgnoreCase(Constants.ANDROID_NET_CHANGE_ACTION)) {
            Log.d(TAG, "网络状态发生了改变=======");
            netType = NetWorkUtil.getNetType();
            if (NetWorkUtil.isNetWorkAvailable()) {
                Log.d(TAG, "监听到连接=====");
                listener.onConnect(netType);
            } else {
                Log.d(TAG, "监听到断开====");
                listener.onDisConnect();
            }

        }
    }


}
