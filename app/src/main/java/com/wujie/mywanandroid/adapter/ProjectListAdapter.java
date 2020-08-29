package com.wujie.mywanandroid.adapter;

import androidx.annotation.Nullable;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.wujie.commonmoudle.GlideApp;
import com.wujie.mywanandroid.R;
import com.wujie.mywanandroid.bean.ProjectItemBean;

import java.util.List;

/**
 * Time：2019/1/15 0015 上午 11:52
 * Author：WuChen
 * Description：
 **/
public class ProjectListAdapter extends BaseQuickAdapter<ProjectItemBean, BaseViewHolder> {

    public ProjectListAdapter(int layoutResId, @Nullable List<ProjectItemBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ProjectItemBean item) {
        helper.setText(R.id.tv_name, item.getTitle()+"")
                .setText(R.id.tv_desc, item.getDesc()+"")
                .setText(R.id.tv_time, item.getNiceDate()+"")
                .setText(R.id.tv_author, item.getAuthor()+"");
        GlideApp.with(mContext).load(item.getEnvelopePic()).centerCrop().placeholder(R.mipmap.ic_launcher).into((ImageView)helper.getView(R.id.iv_project));
    }
}
