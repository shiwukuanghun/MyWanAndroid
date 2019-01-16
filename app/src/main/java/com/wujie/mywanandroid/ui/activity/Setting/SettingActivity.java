package com.wujie.mywanandroid.ui.activity.Setting;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.wujie.commonmoudle.base.BaseActivity;
import com.wujie.commonmoudle.presenter.BasePresenter;
import com.wujie.commonmoudle.utils.ARouterUtils;
import com.wujie.mywanandroid.R;

/**
 * Time：2019/1/16 0016 上午 11:46
 * Author：WuChen
 * Description：设置
 * **/
@Route(path = ARouterUtils.SettingPath)
public class SettingActivity extends BaseActivity {
    @Override
    protected int getLayoutId() {
        return R.layout.activity_setting;
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected void init() {

    }
}
