package com.wujie.commonmoudle.net;

/**
 * Created by HuangBin on 2018/11/16 19:56.
 * Description：
 */

public interface NetConfig {

    int REQUEST_SUCCESS = 0; //请求成功
    int REQUEST_ERROR = -1;  //请求失败
    /**
     * 连接错误,网络异常
     */
    int CONNECT_ERROR = 1001;
    /**
     * 连接超时
     */
    int CONNECT_TIMEOUT = 1002;

    /**
     * 解析错误
     */
    int PARSE_ERROR = 1003;
    /**
     * 未知错误
     */
    int UNKNOWN_ERROR = 1004;

    /**
     * 请求超时
     */
    int REQUEST_TIMEOUT = 1005;

}
