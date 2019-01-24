package com.wujie.mywanandroid.ui.fragment.todo;

import com.wujie.commonmoudle.net.BaseObserver;
import com.wujie.commonmoudle.presenter.BasePresenter;
import com.wujie.mywanandroid.bean.PageListDataBean;
import com.wujie.mywanandroid.bean.TodoBean;
import com.wujie.mywanandroid.net.RxHelper;
import com.wujie.mywanandroid.net.RxRetrofit;

/**
 * Time：2019/1/23 0023 下午 15:30
 * Author：WuChen
 * Description：
 **/
public class WaitTodoPresenter extends BasePresenter<WaiteTodoContact.View> implements WaiteTodoContact.Presenter {
    @Override
    public void getTodoList(int page, int status, int type, int priority, int orderby) {
        addDisposable(RxRetrofit.getApi()
                .getTodoList(page, status, type, priority, orderby)
                .compose(RxHelper.rxSchedulderHelper())
                .compose(RxHelper.handleResult2())
                .subscribeWith(new BaseObserver<PageListDataBean<TodoBean>>() {
                    @Override
                    protected void start() {

                    }

                    @Override
                    protected void onSuccess(PageListDataBean<TodoBean> pageListDataBean) {
                        mV.getTodoListSuccess(pageListDataBean);
                    }

                    @Override
                    protected void onFailure(int errorCode, String errorMsg) {

                    }
                }));

    }
}
