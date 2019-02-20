package com.xq.mylibrary.utils;


import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.provider.Settings;

import com.xq.mylibrary.type.NetType;

public class NetWorkUtil {

    public static boolean isNetWorkAvailable() {
        ConnectivityManager manager = (ConnectivityManager) NetWorkManager.getInstance().getApplication()
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        if (manager == null) {
            return false;
        }

        NetworkInfo[] info = manager.getAllNetworkInfo();
        if (info != null) {
            for (NetworkInfo networkInfo : info) {
                if (networkInfo.getState() == NetworkInfo.State.CONNECTED) {
                    return true;
                }
            }
        }

        return false;
    }

    public static NetType getNetType() {
        ConnectivityManager manager = (ConnectivityManager) NetWorkManager.getInstance().getApplication()
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        if (manager == null) {
            return NetType.NONE;
        }

        NetworkInfo info = manager.getActiveNetworkInfo();
        if (info == null) {
            return NetType.NONE;
        }

        int type = info.getType();

        switch (type) {
            case ConnectivityManager.TYPE_MOBILE:
                if (info.getExtraInfo().toLowerCase().equals("cmnet")) {
                    return NetType.CMNET;
                } else {
                    return NetType.CMWAP;
                }
            case ConnectivityManager.TYPE_WIFI:
                return NetType.WIFI;
        }

        return NetType.NONE;
    }

    public static void openSetting(Context context, int requestCode) {
        Intent intent = new Intent("/");
        ComponentName cm = new ComponentName("com.android.settings", Settings.ACTION_WIRELESS_SETTINGS);
        intent.setComponent(cm);
        intent.setAction("android.intent.action.VIEW");
        ((Activity) context).startActivityForResult(intent, requestCode);
    }
}
