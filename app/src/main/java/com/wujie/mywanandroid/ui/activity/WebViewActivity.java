package com.wujie.mywanandroid.ui.activity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.wujie.commonmoudle.base.BaseActivity;
import com.wujie.commonmoudle.presenter.BasePresenter;
import com.wujie.commonmoudle.utils.ARouterUtils;
import com.wujie.mywanandroid.R;

import butterknife.BindView;

/**
 * Time：2019/1/14 0014 上午 10:08
 * Author：WuChen
 * Description：
 **/
@Route(path = ARouterUtils.WebViewPath)
public class WebViewActivity extends BaseActivity {
    @BindView(R.id.web_view)
    WebView mWebView;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_webview;
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected void init() {
        String webUrl = getIntent().getStringExtra("WebUrl");
        WebSettings settings = mWebView.getSettings();
        settings.setJavaScriptEnabled(true);
        mWebView.loadUrl(webUrl);
    }

}
