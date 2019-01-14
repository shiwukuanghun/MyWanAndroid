package com.wujie.commonmoudle;

import android.app.Application;

import com.wujie.commonmoudle.utils.SpUtils;

/**
 * Time：2019/1/11 0011 下午 14:00
 * Author：WuChen
 * Description：
 **/
public class BaseApplication extends Application {

    private static BaseApplication sBaseApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        sBaseApplication = this;
        SpUtils.init(this);
    }

    public static BaseApplication getBaseApplication() {
        return sBaseApplication;
    }
}
