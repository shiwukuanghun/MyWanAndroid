package com.wujie.mywanandroid.ui.fragment.todo;

import android.os.Bundle;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.wujie.commonmoudle.base.BaseFragment;
import com.wujie.commonmoudle.presenter.BasePresenter;
import com.wujie.mywanandroid.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Time：2019/1/23 0023 下午 15:15
 * Author：WuChen
 * Description：
 **/
public class CompleteTodoFragment extends BaseFragment {
    @BindView(R.id.rv_todo)
    RecyclerView mRvTodo;
    @BindView(R.id.srl)
    SmartRefreshLayout mSrl;
    Unbinder unbinder;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_wait_todo;
    }

    @Override
    protected void init(View view) {

    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
