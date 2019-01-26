package com.wujie.mywanandroid.ui.fragment.navigation;

import com.wujie.commonmoudle.presenter.IPresenter;
import com.wujie.commonmoudle.view.IBaseView;
import com.wujie.mywanandroid.bean.NavigationBean;

import java.util.List;

/**
 * Time：2019/1/25 0025 下午 18:09
 * Author：WuChen
 * Description：
 **/
public interface NavigationContact {

    interface View extends IBaseView {
        void getNavigationSuccess(List<NavigationBean> navigationBeanList);
    }

    interface Presenter extends IPresenter<View> {
        void getNavigation();
    }

}
