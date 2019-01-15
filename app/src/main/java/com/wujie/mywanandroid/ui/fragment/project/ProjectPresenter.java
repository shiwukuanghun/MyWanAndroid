package com.wujie.mywanandroid.ui.fragment.project;

import com.wujie.commonmoudle.net.BaseObserver;
import com.wujie.commonmoudle.presenter.BasePresenter;
import com.wujie.mywanandroid.bean.ProjectTypeBean;
import com.wujie.mywanandroid.net.RxHelper;
import com.wujie.mywanandroid.net.RxRetrofit;

import java.util.List;

/**
 * Time：2019/1/14 0014 下午 17:38
 * Author：WuChen
 * Description：
 **/
public class ProjectPresenter extends BasePresenter<ProjectContact.View> implements ProjectContact.Presenter {
    @Override
    public void getProjectType() {
        addDisposable(RxRetrofit.getApi()
                .getProjectType()
                .compose(RxHelper.rxSchedulderHelper())
                .compose(RxHelper.handleResult2())
                .subscribeWith(new BaseObserver<List<ProjectTypeBean>>() {
                    @Override
                    protected void start() {

                    }

                    @Override
                    protected void onSuccess(List<ProjectTypeBean> projectTypeBeans) {
                        mV.getProjectType(projectTypeBeans);
                    }

                    @Override
                    protected void onFailure(int errorCode, String errorMsg) {

                    }
                }));
    }
}
