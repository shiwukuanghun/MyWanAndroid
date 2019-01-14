package com.wujie.mywanandroid.net;

import android.text.TextUtils;

import com.wujie.commonmoudle.utils.SpUtils;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Time：2019/1/10 0010 下午 18:32
 * Author：WuChen
 * Description：
 **/
public class ReadCookiesInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request.Builder builder = chain.request().newBuilder();
        String mCookieStr = (String) SpUtils.get(chain.request().url().host(), "");
        if (!TextUtils.isEmpty(mCookieStr)) {
            builder.addHeader("Cookie", mCookieStr.substring(0, mCookieStr.length() - 1));//长度减1为了去除最后的逗号
        }
        return chain.proceed(builder.build());
    }
}
