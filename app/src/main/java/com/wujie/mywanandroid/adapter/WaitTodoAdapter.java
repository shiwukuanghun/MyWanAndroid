package com.wujie.mywanandroid.adapter;

import com.chad.library.adapter.base.BaseSectionQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.wujie.mywanandroid.R;
import com.wujie.mywanandroid.bean.TodoSection;

import java.util.List;

/**
 * Time：2019/1/23 0023 下午 15:34
 * Author：WuChen
 * Description：
 **/
public class WaitTodoAdapter extends BaseSectionQuickAdapter<TodoSection, BaseViewHolder> {

    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param layoutResId      The layout resource id of each item.
     * @param sectionHeadResId The section head layout id for each item
     * @param data             A new list is created out of this one to avoid mutable list
     */
    public WaitTodoAdapter(int layoutResId, int sectionHeadResId, List<TodoSection> data) {
        super(layoutResId, sectionHeadResId, data);
    }

    @Override
    protected void convertHead(BaseViewHolder helper, TodoSection item) {
        helper.setText(R.id.tv_date, item.header);
    }

    @Override
    protected void convert(BaseViewHolder helper, TodoSection item) {
        helper.setText(R.id.tv_title, item.t.getTitle())
                .setText(R.id.tv_content, item.t.getContent());
    }
}
