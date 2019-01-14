package com.wujie.mywanandroid.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.alibaba.android.arouter.launcher.ARouter;
import com.wujie.commonmoudle.base.BaseFragment;
import com.wujie.commonmoudle.presenter.BasePresenter;
import com.wujie.commonmoudle.utils.ARouterUtils;
import com.wujie.mywanandroid.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Time：2019/1/14 0014 上午 9:42
 * Author：WuChen
 * Description：
 **/
public class MineFragment extends BaseFragment {
    @BindView(R.id.btn_login)
    Button mBtnLogin;
    Unbinder unbinder;
    Unbinder unbinder1;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_mine;
    }

    @Override
    protected void init(View view) {

    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @OnClick(R.id.btn_login)
    public void onViewClicked() {
        ARouter.getInstance().build(ARouterUtils.LoginPath).navigation();
    }
}
