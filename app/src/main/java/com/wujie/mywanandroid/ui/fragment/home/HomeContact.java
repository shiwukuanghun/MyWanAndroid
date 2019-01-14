package com.wujie.mywanandroid.ui.fragment.home;

import com.wujie.commonmoudle.presenter.IPresenter;
import com.wujie.commonmoudle.view.IBaseView;
import com.wujie.mywanandroid.bean.HomeBean;
import com.wujie.mywanandroid.bean.PageListDataBean;

/**
 * Time：2019/1/14 0014 上午 9:47
 * Author：WuChen
 * Description：
 **/
public interface HomeContact {

    interface View extends IBaseView {

        void loadHomeFail(String msg);

        void loadHomeData(PageListDataBean<HomeBean> pageListDataBean);

        void collectOrUnCollect(int position);

        void collectFailure(String msg);

    }

    interface Presenter extends IPresenter<View> {

        void getHomeList(int page);

        void collectOrUnCollectArticle(int id, int position);

    }

}
