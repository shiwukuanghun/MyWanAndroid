package com.wujie.mywanandroid.adapter;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.wujie.mywanandroid.ui.fragment.todo.WaitTodoFragment;

/**
 * Time：2019/1/23 0023 下午 15:34
 * Author：WuChen
 * Description：
 **/
public class TodoPageAdapter extends FragmentPagerAdapter {

    private String[] mTitles;

    public TodoPageAdapter(FragmentManager fm, String[] titles) {
        super(fm);
        mTitles = titles;
    }

    @Override
    public Fragment getItem(int i) {
        return new WaitTodoFragment();
    }

    @Override
    public int getCount() {
        return mTitles.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }
}
