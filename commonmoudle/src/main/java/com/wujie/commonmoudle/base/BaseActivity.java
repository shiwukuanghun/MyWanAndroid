package com.wujie.commonmoudle.base;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.gyf.barlibrary.ImmersionBar;
import com.wujie.commonmoudle.R;
import com.wujie.commonmoudle.presenter.BasePresenter;
import com.wujie.commonmoudle.view.IBaseView;

import butterknife.ButterKnife;
import me.imid.swipebacklayout.lib.app.SwipeBackActivity;

/**
 * Time：2019/1/11 0011 下午 14:01
 * Author：WuChen
 * Description：
 **/
public abstract class BaseActivity<P extends BasePresenter<V>, V extends IBaseView> extends SwipeBackActivity implements IBaseView  {

    protected P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        setSwipeBackEnable(true);
        mPresenter = createPresenter();
        if (null != mPresenter) {
            mPresenter.attachView((V) this);
        }
        ImmersionBar.with(this).statusBarColor(R.color.yellow).init();
        init();
    }

    protected abstract int getLayoutId();

    protected abstract P createPresenter();

    protected abstract void init();

    protected void initStatusBar(boolean isLightMode, int statusBarColor) {
        ImmersionBar.with(this)
                .statusBarDarkFont(isLightMode)
                .statusBarColor(statusBarColor)
                .init();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (null != mPresenter) {
            mPresenter.detachView();
            mPresenter.detachView();
        }
        ImmersionBar.with(this).destroy();
    }


    @Override
    public void showLoading(String msg) {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showError() {

    }

    @Override
    public void showFailure(String msg) {

    }

    @Override
    public void showEmpty() {

    }
}
