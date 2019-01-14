package com.wujie.mywanandroid.ui.activity.login;

import com.wujie.commonmoudle.net.BaseObserver;
import com.wujie.commonmoudle.presenter.BasePresenter;
import com.wujie.mywanandroid.net.RxHelper;
import com.wujie.mywanandroid.net.RxRetrofit;

public class LoginPresenter extends BasePresenter<LoginContact.View> implements LoginContact.Presenter {
    @Override
    public void login(String username, String password) {
        addDisposable(RxRetrofit.getApi()
                .login(username, password)
                .compose(RxHelper.rxSchedulderHelper())
                .compose(RxHelper.handleResult2())
                .subscribeWith(new BaseObserver<Object>() {
                    @Override
                    protected void start() {

                    }

                    @Override
                    protected void onSuccess(Object o) {
                        mV.loginSuccess();
                    }

                    @Override
                    protected void onFailure(int errorCode, String errorMsg) {
                        mV.showFailure(errorMsg);
                    }
                }));
    }
/*    @Override
    public void login(String username, String password) {
        addDisposable(RxRetrofit.createApi(ApiServer.class, Constant.BaseUrl)
                .login(username, password)
                .compose(RxHelper.rxSchedulderHelper())
                .compose(RxHelper.handleResult2())
                .subscribeWith(new BaseObserver<Object>() {
                    @Override
                    protected void start() {

                    }

                    @Override
                    protected void onSuccess(Object o) {
                        mV.loginSuccess();
                    }

                    @Override
                    protected void onFailure(int errorCode, String errorMsg) {
                        mV.showFailure(errorMsg);
                    }
                }));


    }*/

    /*@Override
    public void login(String username, String password) {
        RxObserver<Object> rxObserver = new RxObserver<Object>(this) {
            @Override
            protected void start() {

            }

            @Override
            protected void onSuccess(Object o) {
                mV.loginSuccess();
            }

            @Override
            protected void onFailure(int errorCode, String errorMsg) {
                mV.showFailure(errorMsg);
            }
        };
        RxRetrofit.createApi(ApiServer.class, Constant.BaseUrl)
                .login(username, password)
                .compose(RxHelper.rxSchedulderHelper())
                .subscribe(rxObserver);
        addDisposable(rxObserver);
    }*/
}
