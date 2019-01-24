package com.wujie.mywanandroid.ui.fragment.todo;

import com.wujie.commonmoudle.presenter.IPresenter;
import com.wujie.commonmoudle.view.IBaseView;
import com.wujie.mywanandroid.bean.PageListDataBean;
import com.wujie.mywanandroid.bean.TodoBean;

/**
 * Time：2019/1/23 0023 下午 15:28
 * Author：WuChen
 * Description：
 **/
public interface WaiteTodoContact {

    interface View extends IBaseView {
        void getTodoListSuccess(PageListDataBean<TodoBean> pageListDataBean);
    }

    interface Presenter extends IPresenter<View> {
        void getTodoList(int page, int status, int type, int priority, int orderby);
    }

}
