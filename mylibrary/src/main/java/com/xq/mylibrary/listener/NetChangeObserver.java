package com.xq.mylibrary.listener;

import com.xq.mylibrary.type.NetType;

/**
 * 监听网络状态改变的观察者
 *
 */
public interface NetChangeObserver {

    /**
     * 网络状态连接时调用
     */
     void onConnect(NetType netType);

    /**
     * 网络状态断开时调用
     */
     void onDisConnect();

}
