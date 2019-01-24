package com.wujie.mywanandroid.bean;

import com.chad.library.adapter.base.entity.SectionEntity;

/**
 * Time：2019/1/23 0023 下午 16:13
 * Author：WuChen
 * Description：
 **/
public class TodoSection extends SectionEntity<TodoBean> {
    public TodoSection(boolean isHeader, String header) {
        super(isHeader, header);
    }

    public TodoSection(TodoBean todoBean) {
        super(todoBean);
    }
}
