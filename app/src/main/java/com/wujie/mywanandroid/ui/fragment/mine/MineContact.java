package com.wujie.mywanandroid.ui.fragment.mine;

import com.wujie.commonmoudle.presenter.IPresenter;
import com.wujie.commonmoudle.view.IBaseView;

/**
 * Time：2019/1/15 0015 下午 16:07
 * Author：WuChen
 * Description：
 **/
public interface MineContact {

    interface View extends IBaseView {
        void logoutSuccess();
    }

    interface Presenter extends IPresenter<View> {
        void logout();
    }

}
