package com.wujie.mywanandroid.ui.activity.register;

import com.wujie.commonmoudle.presenter.IPresenter;
import com.wujie.commonmoudle.view.IBaseView;

/**
 * Time：2019/1/16 0016 上午 10:08
 * Author：WuChen
 * Description：
 **/
public interface RegisterContact {

    interface View extends IBaseView {
        void registerSuccess();
    }

    interface Presenter extends IPresenter<View> {
        void register(String username, String password, String repassword);
    }

}
