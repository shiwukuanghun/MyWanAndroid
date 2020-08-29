package com.wujie.commonmoudle;

import android.app.Application;
import android.content.Context;

import androidx.multidex.MultiDex;
import androidx.multidex.MultiDexApplication;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;
import com.wujie.commonmoudle.utils.SpUtils;

/**
 * Time：2019/1/11 0011 下午 14:00
 * Author：WuChen
 * Description：
 **/
public class BaseApplication extends MultiDexApplication {

    private static BaseApplication sBaseApplication;
    private RefWatcher mRefWatcher;

    @Override
    public void onCreate() {
        super.onCreate();
        sBaseApplication = this;
        SpUtils.init(this);
        MultiDex.install(this);
//        if (LeakCanary.isInAnalyzerProcess(this)) {
//            // This process is dedicated to LeakCanary for heap analysis.
//            // You should not init your app in this process.
//            return;
//        }
//        mRefWatcher = LeakCanary.install(this);
    }

    public static BaseApplication getBaseApplication() {
        return sBaseApplication;
    }

//    public static RefWatcher getRefWatcher(Context context) {
//        BaseApplication baseApplication = (BaseApplication) context.getApplicationContext();
//        return baseApplication.mRefWatcher;
//    }
}
