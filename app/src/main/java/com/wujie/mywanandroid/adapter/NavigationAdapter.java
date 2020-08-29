package com.wujie.mywanandroid.adapter;

import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.launcher.ARouter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.wujie.commonmoudle.utils.ARouterUtils;
import com.wujie.commonmoudle.utils.CommonUtils;
import com.wujie.commonmoudle.utils.Constant;
import com.wujie.mywanandroid.R;
import com.wujie.mywanandroid.bean.NavigationBean;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.List;

/**
 * Time：2019/1/26 0026 上午 10:24
 * Author：WuChen
 * Description：
 **/
public class NavigationAdapter extends BaseQuickAdapter<NavigationBean, BaseViewHolder> {
    public NavigationAdapter(int layoutResId, @Nullable List<NavigationBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, NavigationBean item) {
        helper.setText(R.id.tv_title, item.getName());
        TagFlowLayout flowLayout = (TagFlowLayout) helper.getView(R.id.flow_layout);
        flowLayout.setAdapter(new TagAdapter<NavigationBean.ArticlesBean>(item.getArticles()) {
            @Override
            public View getView(FlowLayout parent, int position, NavigationBean.ArticlesBean articlesBean) {
                TextView textView = (TextView) LayoutInflater.from(parent.getContext()).inflate(R.layout.tv_flowlayout, flowLayout, false);
                textView.setText(articlesBean.getTitle());
                textView.setTextColor(CommonUtils.randomColor());
                return textView;
            }
        });
        flowLayout.setOnTagClickListener((view, position, parent) -> {
            ARouter.getInstance().build(ARouterUtils.WebViewPath).withString(Constant.WebUrl, item.getArticles().get(position).getLink()).navigation();
            return false;
        });
    }

}
