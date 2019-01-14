package com.wujie.mywanandroid.ui.fragment.home;

import com.wujie.commonmoudle.net.BaseObserver;
import com.wujie.commonmoudle.net.RxObserver;
import com.wujie.commonmoudle.presenter.BasePresenter;
import com.wujie.commonmoudle.utils.Constant;
import com.wujie.mywanandroid.bean.HomeBean;
import com.wujie.mywanandroid.bean.PageListDataBean;
import com.wujie.mywanandroid.net.ApiServer;
import com.wujie.mywanandroid.net.RxHelper;
import com.wujie.mywanandroid.net.RxRetrofit;

/**
 * Time：2019/1/14 0014 上午 9:47
 * Author：WuChen
 * Description：
 **/
public class HomePresenter extends BasePresenter<HomeContact.View> implements HomeContact.Presenter {


    @Override
    public void getHomeList(int page) {
        RxObserver<PageListDataBean<HomeBean>> rxObserver = new RxObserver<PageListDataBean<HomeBean>>(this) {
            @Override
            protected void start() {
                mV.showLoading("");
            }

            @Override
            protected void onSuccess(PageListDataBean<HomeBean> homeBeanPageListDataBean) {
                if (homeBeanPageListDataBean != null && homeBeanPageListDataBean.getDatas() != null && homeBeanPageListDataBean.getDatas().size() > 0) {
                    mV.loadHomeData(homeBeanPageListDataBean);
                } else {
                    mV.showEmpty();
                }
            }

            @Override
            protected void onFailure(int errorCode, String errorMsg) {
                if (errorCode == -1) {
                    mV.showError();
                } else {
                    mV.showFailure(errorMsg);
                }
            }
        };
        RxRetrofit.createApi(ApiServer.class, Constant.BaseUrl)
                .getHomeList(page)
                .compose(RxHelper.rxSchedulderHelper())
                .subscribe(rxObserver);
        addDisposable(rxObserver);
    }

    @Override
    public void collectOrUnCollectArticle(int id, int position) {
        addDisposable(RxRetrofit.getApi()
                .collectArticle(id)
                .compose(RxHelper.rxSchedulderHelper())
                .compose(RxHelper.handleCollectResult())
                .subscribeWith(new BaseObserver<Object>() {
                    @Override
                    protected void start() {

                    }

                    @Override
                    protected void onSuccess(Object o) {
                        mV.collectOrUnCollect(position);
                    }

                    @Override
                    protected void onFailure(int errorCode, String errorMsg) {
                        mV.collectFailure(errorMsg);
                    }
                }));
    }
}
