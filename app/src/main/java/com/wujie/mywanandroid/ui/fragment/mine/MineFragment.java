package com.wujie.mywanandroid.ui.fragment.mine;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.alibaba.android.arouter.launcher.ARouter;
import com.wujie.commonmoudle.base.BaseFragment;
import com.wujie.commonmoudle.utils.ARouterUtils;
import com.wujie.commonmoudle.utils.Constant;
import com.wujie.commonmoudle.utils.SpUtils;
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
public class MineFragment extends BaseFragment<MinePresenter, MineContact.View> implements MineContact.View {
    @BindView(R.id.btn_login)
    Button mBtnLogin;
    @BindView(R.id.btn_logout)
    Button mBtnLogout;
    @BindView(R.id.btn_register)
    Button mBtnRegister;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_mine;
    }

    @Override
    protected void init(View view) {

    }

    @Override
    protected MinePresenter createPresenter() {
        return new MinePresenter();
    }

    @OnClick({R.id.btn_login, R.id.btn_register, R.id.btn_logout, R.id.btn_setting, R.id.btn_todo})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                ARouter.getInstance().build(ARouterUtils.LoginPath).navigation();
                break;
            case R.id.btn_register:
                ARouter.getInstance().build(ARouterUtils.RegisterPath).navigation();
                break;
            case R.id.btn_logout:
                mPresenter.logout();
                break;
            case R.id.btn_setting:
                ARouter.getInstance().build(ARouterUtils.SettingPath).navigation();
                break;
            case R.id.btn_todo:
                ARouter.getInstance().build(ARouterUtils.TodoPath).navigation();
                break;
        }
    }

    @Override
    public void logoutSuccess() {
        Toast.makeText(getContext(), "退出成功", Toast.LENGTH_SHORT).show();
        SpUtils.remove(Constant.LoginInfo);
    }

}
