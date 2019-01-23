package com.wujie.mywanandroid.ui.activity.todo;

import com.wujie.commonmoudle.presenter.IPresenter;
import com.wujie.commonmoudle.view.IBaseView;
import com.wujie.mywanandroid.bean.AddTodoBean;

/**
 * Time：2019/1/23 0023 下午 14:31
 * Author：WuChen
 * Description：
 **/
public interface AddTodoContact {

    interface View extends IBaseView {
        void addTodoSuccess(AddTodoBean addTodoBean);
    }

    interface Presenter extends IPresenter<View> {
        void addTodo(String title, String content, String date, int type, int priority);
    }

}
