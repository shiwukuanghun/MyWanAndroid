package com.wujie.mywanandroid.ui.activity.todo;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.gyf.barlibrary.ImmersionBar;
import com.wujie.commonmoudle.base.BaseActivity;
import com.wujie.commonmoudle.presenter.BasePresenter;
import com.wujie.commonmoudle.utils.ARouterUtils;
import com.wujie.mywanandroid.R;

/**
 * Time：2019/1/21 0021 下午 15:21
 * Author：WuChen
 * Description：todo界面
 **/
@Route(path = ARouterUtils.TodoPath)
public class TodoActivity extends BaseActivity {
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
}
