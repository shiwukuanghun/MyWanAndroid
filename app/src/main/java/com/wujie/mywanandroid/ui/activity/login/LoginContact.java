package com.wujie.mywanandroid.ui.activity.login;

import com.wujie.commonmoudle.presenter.IPresenter;
import com.wujie.commonmoudle.view.IBaseView;

public interface LoginContact {

    interface View extends IBaseView {
        void loginSuccess();
    }

    interface Presenter extends IPresenter<View> {
        void login(String username, String password);
    }

}
