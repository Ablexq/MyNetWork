package com.xq.mylibrary.type;

/**
 * 网络类型枚举类
 */
public enum NetType {
    AUTO,//有网络，包括WiFi、GPRS
    WIFI,
    CMNET,//GPRS：pc/笔记本电脑/pda
    CMWAP,//GPRS：手机
    NONE;//无网络

}
