package com.wujie.mywanandroid.ui.fragment;

import android.view.View;

import com.wujie.commonmoudle.base.BaseFragment;
import com.wujie.commonmoudle.presenter.BasePresenter;
import com.wujie.mywanandroid.R;

/**
 * Time：2019/1/14 0014 上午 9:42
 * Author：WuChen
 * Description：
 **/
public class NavigationFragment extends BaseFragment {
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_navigation;
    }

    @Override
    protected void init(View view) {

    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }
}
