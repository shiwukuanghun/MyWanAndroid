package com.wujie.mywanandroid.adapter;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.wujie.mywanandroid.bean.ProjectTypeBean;
import com.wujie.mywanandroid.ui.fragment.project.ProjectListFragment;

import java.util.List;

/**
 * Time：2019/1/15 0015 上午 11:18
 * Author：WuChen
 * Description：
 **/
public class ProjectTypeAdapter extends FragmentStatePagerAdapter {
    private List<ProjectTypeBean> mProjectTypeBeanList;

    public ProjectTypeAdapter(FragmentManager fm, List<ProjectTypeBean> projectTypeBeanList) {
        super(fm);
        mProjectTypeBeanList = projectTypeBeanList;
    }

    @Override
    public Fragment getItem(int i) {
        return ProjectListFragment.instantiate(mProjectTypeBeanList.get(i).getId());
    }

    @Override
    public int getCount() {
        return mProjectTypeBeanList == null ? 0 : mProjectTypeBeanList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mProjectTypeBeanList.get(position).getName();
    }
}
