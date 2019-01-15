package com.wujie.mywanandroid.ui.fragment.project;

import com.wujie.commonmoudle.presenter.IPresenter;
import com.wujie.commonmoudle.view.IBaseView;
import com.wujie.mywanandroid.bean.ProjectTypeBean;

import java.util.List;

/**
 * Time：2019/1/14 0014 下午 17:38
 * Author：WuChen
 * Description：
 **/
public interface ProjectContact {

    interface View extends IBaseView {
        void getProjectType(List<ProjectTypeBean> projectTypeBeanList);
    }

    interface Presenter extends IPresenter<View> {
        void getProjectType();
    }

}
