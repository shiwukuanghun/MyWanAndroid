package com.wujie.mywanandroid.ui.activity.todo;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.gyf.barlibrary.ImmersionBar;
import com.wujie.commonmoudle.base.BaseActivity;
import com.wujie.commonmoudle.presenter.BasePresenter;
import com.wujie.commonmoudle.utils.ARouterUtils;
import com.wujie.mywanandroid.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Time：2019/1/21 0021 下午 15:21
 * Author：WuChen
 * Description：todo界面
 **/
@Route(path = ARouterUtils.TodoPath)
public class TodoActivity extends BaseActivity {
    @BindView(R.id.view)
    View mView;
    @BindView(R.id.iv_add_icon)
    ImageView mIvAddIcon;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_todo;
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected void init() {
        ImmersionBar.with(this)
                .transparentStatusBar()
                .statusBarView(R.id.view)
                .init();
    }

    @OnClick(R.id.iv_add_icon)
    public void onViewClicked() {
        ARouter.getInstance().build(ARouterUtils.AddTodoPath).navigation();
    }
}
