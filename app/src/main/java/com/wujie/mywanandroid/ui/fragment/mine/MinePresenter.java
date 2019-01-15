package com.wujie.mywanandroid.ui.fragment.mine;

import com.wujie.commonmoudle.net.BaseObserver;
import com.wujie.commonmoudle.presenter.BasePresenter;
import com.wujie.mywanandroid.net.RxHelper;
import com.wujie.mywanandroid.net.RxRetrofit;

/**
 * Time：2019/1/15 0015 下午 16:07
 * Author：WuChen
 * Description：
 **/
public class MinePresenter extends BasePresenter<MineContact.View> implements MineContact.Presenter {
    @Override
    public void logout() {
        addDisposable(RxRetrofit.getApi()
                .logout()
                .compose(RxHelper.rxSchedulderHelper())
                .compose(RxHelper.handleLogoutResult())
                .subscribeWith(new BaseObserver<Object>() {
                    @Override
                    protected void start() {

                    }

                    @Override
                    protected void onSuccess(Object o) {
                        mV.logoutSuccess();
                    }

                    @Override
                    protected void onFailure(int errorCode, String errorMsg) {

                    }
                }));
    }
}
