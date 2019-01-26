package com.wujie.mywanandroid.utils;

import android.text.TextUtils;

import com.alibaba.android.arouter.launcher.ARouter;
import com.wujie.commonmoudle.utils.ARouterUtils;
import com.wujie.commonmoudle.utils.Constant;
import com.wujie.commonmoudle.utils.SpUtils;

/**
 * Time：2019/1/26 0026 下午 15:31
 * Author：WuChen
 * Description：
 **/
public class LoginUtils {

    public static boolean isLogin() {
        String loginInfo = (String) SpUtils.get(Constant.LoginInfo, "");
        if (TextUtils.isEmpty(loginInfo)) {
            return false;
        } else {
            return true;
        }
    }

}
