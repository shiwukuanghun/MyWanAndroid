package com.wujie.mywanandroid.ui.activity.login;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.wujie.commonmoudle.base.BaseActivity;
import com.wujie.commonmoudle.utils.ARouterUtils;
import com.wujie.mywanandroid.R;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Time：2019/1/14 0014 上午 10:10
 * Author：WuChen
 * Description：
 **/
@Route(path = ARouterUtils.LoginPath)
public class LoginActivity extends BaseActivity<LoginPresenter, LoginContact.View> implements LoginContact.View {
    @BindView(R.id.et_name)
    EditText mEtName;
    @BindView(R.id.et_pwd)
    EditText mEtPwd;
    @BindView(R.id.btn_login)
    Button mBtnLogin;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected LoginPresenter createPresenter() {
        return new LoginPresenter();
    }

    @Override
    protected void init() {

    }

    @Override
    public void loginSuccess() {
        Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
        finish();
    }

    @OnClick(R.id.btn_login)
    public void onViewClicked() {
        String username = mEtName.getText().toString().trim();
        String password = mEtPwd.getText().toString().trim();
        mPresenter.login(username, password);
    }
}
