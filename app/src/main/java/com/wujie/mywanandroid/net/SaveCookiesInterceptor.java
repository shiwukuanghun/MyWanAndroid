package com.wujie.mywanandroid.net;

import com.wujie.commonmoudle.utils.Constant;
import com.wujie.commonmoudle.utils.SpUtils;

import java.io.IOException;
import java.util.List;

import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * Time：2019/1/10 0010 下午 18:29
 * Author：WuChen
 * Description：
 **/
public class SaveCookiesInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Response response = chain.proceed(chain.request());
        List<String> mCookieList = response.headers("Set-Cookie");
        //保存Cookie
        if (!mCookieList.isEmpty() && chain.request().url().toString().endsWith("user/login")) {
            StringBuilder sb = new StringBuilder();
            for (String cookie : mCookieList) {
                //注意Cookie请求头字段中的每个Cookie之间用逗号或分号分隔
                sb.append(cookie).append(",");
            }
//            SpUtils.put(response.request().url().host(), sb.toString());
            SpUtils.put(Constant.LoginInfo, sb.toString());
//            Log.e(SaveCookieInterceptor.class.getSimpleName(), "intercept: url : " + request.url());
        }
        return response;
    }
}
