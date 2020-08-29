package com.wujie.mywanandroid.adapter;

import androidx.annotation.Nullable;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.wujie.mywanandroid.R;
import com.wujie.mywanandroid.bean.HomeBean;

import java.util.List;

/**
 * Created by HuangBin on 2018/11/16 11:35.
 * Description：
 */

public class HomeAdapter extends BaseQuickAdapter<HomeBean, BaseViewHolder> {
    public HomeAdapter(int layoutResId, @Nullable List<HomeBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, HomeBean item) {
        helper.setText(R.id.tv_author, item.getAuthor() + "")
                .setText(R.id.tv_title, item.getTitle())
                .setText(R.id.tv_type, item.getChapterName())
                .addOnClickListener(R.id.iv_collect);
        ((ImageView)helper.getView(R.id.iv_collect)).setImageResource(item.isCollect()?R.mipmap.icon_collect_yes:R.mipmap.icon_collect_no);
//        SkinManager.get().setTextViewColor((TextView)helper.getView(R.id.tv_title), R.color.colorPrimary);
    }

}
