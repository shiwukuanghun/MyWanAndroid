package com.wujie.mywanandroid.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.wujie.mywanandroid.R;
import com.wujie.mywanandroid.bean.KnowledgeBean;

import java.util.List;

/**
 * Time：2019/1/11 0011 上午 11:08
 * Author：WuChen
 * Description：
 **/
public class KnowledgeAdapter extends BaseQuickAdapter<KnowledgeBean, BaseViewHolder> {
    public KnowledgeAdapter(int layoutResId, @Nullable List<KnowledgeBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, KnowledgeBean item) {
        helper.setText(R.id.tv_title, item.getName());
        List<KnowledgeBean.ChildrenBean> children = item.getChildren();
        String desc="";
        for (KnowledgeBean.ChildrenBean childrenBean : children){
            desc += childrenBean.getName() + "   ";
        }
        helper.setText(R.id.tv_desc, desc);
    }
}
