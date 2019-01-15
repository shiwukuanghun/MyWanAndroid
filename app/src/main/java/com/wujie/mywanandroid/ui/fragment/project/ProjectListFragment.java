package com.wujie.mywanandroid.ui.fragment.project;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.wujie.commonmoudle.base.BaseFragment;
import com.wujie.mywanandroid.R;
import com.wujie.mywanandroid.adapter.ProjectListAdapter;
import com.wujie.mywanandroid.bean.PageListDataBean;
import com.wujie.mywanandroid.bean.ProjectItemBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Time：2019/1/15 0015 上午 11:36
 * Author：WuChen
 * Description：
 **/
public class ProjectListFragment extends BaseFragment<ProjectListPresenter, ProjectListContact.View> implements ProjectListContact.View {
    @BindView(R.id.rv_project)
    RecyclerView mRvProject;
    @BindView(R.id.srl_project)
    SmartRefreshLayout mSrlProject;

    private ProjectListAdapter mProjectListAdapter;

    public static ProjectListFragment instantiate(int id) {
        ProjectListFragment projectListFragment = new ProjectListFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("ID", id);
        projectListFragment.setArguments(bundle);
        return projectListFragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_project_list;
    }

    @Override
    protected void init(View view) {
        Bundle bundle = getArguments();
        int id = bundle.getInt("ID");
        mRvProject.setHasFixedSize(true);
        mRvProject.setLayoutManager(new LinearLayoutManager(getContext()));
        List<ProjectItemBean> projectItemBeans = new ArrayList<>();
        mProjectListAdapter = new ProjectListAdapter(R.layout.item_project, projectItemBeans);
        mRvProject.setAdapter(mProjectListAdapter);
        mPresenter.getProjectList(id);
    }

    @Override
    protected ProjectListPresenter createPresenter() {
        return new ProjectListPresenter();
    }

    @Override
    public void getProjectList(PageListDataBean<ProjectItemBean> pageListDataBean) {
        if (pageListDataBean.getDatas()!=null&&pageListDataBean.getDatas().size()>0) {
            mProjectListAdapter.setNewData(pageListDataBean.getDatas());
        }
    }

}
