package com.wujie.mywanandroid.ui.fragment.project;

import com.wujie.commonmoudle.presenter.IPresenter;
import com.wujie.commonmoudle.view.IBaseView;
import com.wujie.mywanandroid.bean.PageListDataBean;
import com.wujie.mywanandroid.bean.ProjectItemBean;

import java.util.List;

/**
 * Time：2019/1/15 0015 上午 11:44
 * Author：WuChen
 * Description：
 **/
public interface ProjectListContact {

    interface View extends IBaseView {
        void getProjectList(PageListDataBean<ProjectItemBean> pageListDataBean);
    }

    interface Presenter extends IPresenter<View> {
        void getProjectList(int cid);
    }

}
