package com.wujie.mywanandroid.ui.activity.register;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.wujie.commonmoudle.base.BaseActivity;
import com.wujie.commonmoudle.presenter.BasePresenter;
import com.wujie.commonmoudle.utils.ARouterUtils;
import com.wujie.mywanandroid.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Time：2019/1/15 0015 下午 16:47
 * Author：WuChen
 * Description：注册
 **/
@Route(path = ARouterUtils.RegisterPath)
public class RegisterActivity extends BaseActivity<RegisterPresenter, RegisterContact.View> implements RegisterContact.View {
    @BindView(R.id.et_username)
    EditText mEtUsername;
    @BindView(R.id.et_pwd)
    EditText mEtPwd;
    @BindView(R.id.et_pwd_again)
    EditText mEtPwdAgain;
    @BindView(R.id.btn_register)
    Button mBtnRegister;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_register;
    }

    @Override
    protected RegisterPresenter createPresenter() {
        return new RegisterPresenter();
    }

    @Override
    protected void init() {

    }

    @OnClick(R.id.btn_register)
    public void onViewClicked() {
        if (isEmpty(mEtUsername)) {
            Toast.makeText(this, "用户名不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        if (isEmpty(mEtPwd)) {
            Toast.makeText(mContext, "密码不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        if (isEmpty(mEtPwdAgain)) {
            Toast.makeText(mContext, "确认密码不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!getText(mEtPwd).equals(getText(mEtPwdAgain))) {
            Toast.makeText(mContext, "两次密码输入不一致", Toast.LENGTH_SHORT).show();
            return;
        }
        mPresenter.register(getText(mEtUsername), getText(mEtPwd), getText(mEtPwdAgain));
    }

    @Override
    public void registerSuccess() {

    }
}
