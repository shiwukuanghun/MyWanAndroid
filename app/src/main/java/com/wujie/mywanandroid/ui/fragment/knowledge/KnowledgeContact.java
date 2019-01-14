package com.wujie.mywanandroid.ui.fragment.knowledge;

import com.wujie.commonmoudle.presenter.IPresenter;
import com.wujie.commonmoudle.view.IBaseView;
import com.wujie.mywanandroid.bean.KnowledgeBean;

import java.util.List;

/**
 * Time：2019/1/11 0011 上午 10:55
 * Author：WuChen
 * Description：
 **/
public interface KnowledgeContact {

    interface View extends IBaseView {
        void getKnowledge(List<KnowledgeBean> knowledgeBeanList);
    }

    interface Presenter extends IPresenter<View> {
        void getKnowledge();
    }

}
