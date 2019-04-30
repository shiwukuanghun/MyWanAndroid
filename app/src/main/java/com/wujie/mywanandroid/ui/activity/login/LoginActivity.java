package com.wujie.mywanandroid.ui.activity.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.gyf.barlibrary.ImmersionBar;
import com.jakewharton.rxbinding3.InitialValueObservable;
import com.jakewharton.rxbinding3.widget.RxTextView;
import com.wind.me.xskinloader.SkinInflaterFactory;
import com.wind.me.xskinloader.SkinManager;
import com.wind.me.xskinloader.util.AssetFileUtils;
import com.wujie.commonmoudle.base.BaseActivity;
import com.wujie.commonmoudle.utils.ARouterUtils;
import com.wujie.mywanandroid.R;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;

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
    @BindView(R.id.view)
    View mView;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    private boolean mFlag = true;

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
        SkinManager.get().setViewBackground(mToolbar, R.color.colorPrimary);
        SkinManager.get().setViewBackground(mView, R.color.colorPrimary);
//        initStatusBar(true, R.color.blue);
        SkinManager.get().setWindowStatusBarColor(this.getWindow(), R.color.colorPrimary);
        ImmersionBar.with(this)
                .transparentStatusBar()
                .statusBarView(R.id.view)
//                .titleBar(R.id.toolbar)
//                .statusBarColor(R.color.blue)
                .navigationBarColor(R.color.yellow)
                .init();
    }

    @Override
    public void loginSuccess() {
        Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
        finish();
    }

    @OnClick(R.id.btn_login)
    public void onViewClicked() {
        InitialValueObservable<CharSequence> nameObservable = RxTextView.textChanges(mEtName);
        InitialValueObservable<CharSequence> pwdObservable = RxTextView.textChanges(mEtPwd);
        addDisposable(Observable.combineLatest(nameObservable, pwdObservable, (charSequence, charSequence2) -> TextUtils.isEmpty(charSequence)&&TextUtils.isEmpty(charSequence2)).subscribe(new Consumer<Boolean>() {
            @Override
            public void accept(Boolean aBoolean) throws Exception {
                if (aBoolean) {
                    Toast.makeText(mContext, "用户名或密码不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                mPresenter.login(getText(mEtName), getText(mEtPwd));
            }
        }));
/*        if (mFlag) {
//            changeSkin();
            useNightMode(true);
        } else {
//            restoreDefaultSkin();
            useNightMode(false);
        }
        mFlag = !mFlag;*/
    }

    private void changeSkin() {
        //将assets目录下的皮肤文件拷贝到data/data/.../cache目录下
        String saveDir = getCacheDir().getAbsolutePath() + "/skins";
        String savefileName = "/skin1.skin";
        String asset_dir = "skin/xskinloader-skin-apk-debug.apk";
        File file = new File(saveDir + File.separator + savefileName);
//        if (!file.exists()) {
        AssetFileUtils.copyAssetFile(this, asset_dir, saveDir, savefileName);
//        }
        SkinManager.get().loadNewSkin(file.getAbsolutePath());
    }

    private void restoreDefaultSkin() {
        SkinManager.get().restoreToDefaultSkin();
    }
}
