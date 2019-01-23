package com.wujie.mywanandroid.ui.activity.todo;

import com.wujie.commonmoudle.net.BaseObserver;
import com.wujie.commonmoudle.presenter.BasePresenter;
import com.wujie.mywanandroid.bean.AddTodoBean;
import com.wujie.mywanandroid.net.RxHelper;
import com.wujie.mywanandroid.net.RxRetrofit;

/**
 * Time：2019/1/23 0023 下午 14:42
 * Author：WuChen
 * Description：
 **/
public class AddTodoPresenter extends BasePresenter<AddTodoContact.View> implements AddTodoContact.Presenter {
    @Override
    public void addTodo(String title, String content, String date, int type, int priority) {
        addDisposable(RxRetrofit.getApi()
                .addTodo(title, content, date, type, priority)
                .compose(RxHelper.rxSchedulderHelper())
                .compose(RxHelper.handleResult2())
                .subscribeWith(new BaseObserver<AddTodoBean>() {
                    @Override
                    protected void start() {

                    }

                    @Override
                    protected void onSuccess(AddTodoBean addTodoBean) {
                        mV.addTodoSuccess(addTodoBean);
                    }

                    @Override
                    protected void onFailure(int errorCode, String errorMsg) {

                    }
                }));
    }
}
