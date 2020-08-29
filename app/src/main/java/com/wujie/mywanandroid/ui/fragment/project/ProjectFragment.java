package com.wujie.mywanandroid.ui.fragment.project;

import com.google.android.material.tabs.TabLayout;
import androidx.viewpager.widget.ViewPager;
import android.util.Log;
import android.view.View;

import com.wujie.commonmoudle.base.BaseFragment;
import com.wujie.mywanandroid.R;
import com.wujie.mywanandroid.adapter.ProjectTypeAdapter;
import com.wujie.mywanandroid.bean.ProjectTypeBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Time：2019/1/14 0014 下午 16:22
 * Author：WuChen
 * Description：
 **/
public class ProjectFragment extends BaseFragment<ProjectPresenter, ProjectContact.View> implements ProjectContact.View {

    private static final String TAG = "ProjectFragment";

    @BindView(R.id.tbl)
    TabLayout mTbl;
    @BindView(R.id.vp)
    ViewPager mVp;

    private List<ProjectTypeBean> mProjectTypeBeanList;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_project;
    }

    @Override
    protected void init(View view) {
        mProjectTypeBeanList = new ArrayList<>();
        mPresenter.getProjectType();
    }

    @Override
    protected ProjectPresenter createPresenter() {
        return new ProjectPresenter();
    }


    @Override
    public void getProjectType(List<ProjectTypeBean> projectTypeBeanList) {
        if (projectTypeBeanList!=null && projectTypeBeanList.size()>0) {
            mProjectTypeBeanList.addAll(projectTypeBeanList);
            Log.d(TAG, "getProjectType: " +mProjectTypeBeanList.size());
            ProjectTypeAdapter projectTypeAdapter = new ProjectTypeAdapter(getChildFragmentManager(), mProjectTypeBeanList);
            mVp.setAdapter(projectTypeAdapter);
            mTbl.setupWithViewPager(mVp);
        }
    }
}
