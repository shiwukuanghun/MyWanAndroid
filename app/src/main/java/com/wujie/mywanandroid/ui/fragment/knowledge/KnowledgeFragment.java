package com.wujie.mywanandroid.ui.fragment.knowledge;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.wujie.commonmoudle.base.BaseFragment;
import com.wujie.mywanandroid.R;
import com.wujie.mywanandroid.adapter.KnowledgeAdapter;
import com.wujie.mywanandroid.bean.KnowledgeBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.Unbinder;

/**
 * Time：2019/1/14 0014 上午 9:42
 * Author：WuChen
 * Description：
 **/
public class KnowledgeFragment extends BaseFragment<KnowledgePresenter, KnowledgeContact.View> implements KnowledgeContact.View {
    @BindView(R.id.rv_knowledge)
    RecyclerView mRvKnowledge;
    @BindView(R.id.srl_knowledge)
    SmartRefreshLayout mSrlKnowledge;
    private KnowledgeAdapter mKnowledgeAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_knowledge;
    }

    @Override
    protected void init(View view) {
        initLoading(mSrlKnowledge);
        List<KnowledgeBean> knowledgeBeanList = new ArrayList<>();
        mRvKnowledge.setHasFixedSize(true);
        mRvKnowledge.setLayoutManager(new LinearLayoutManager(getContext()));
        mKnowledgeAdapter = new KnowledgeAdapter(R.layout.item_knowledge, knowledgeBeanList);
        mRvKnowledge.setAdapter(mKnowledgeAdapter);
        mPresenter.getKnowledge();
    }

    @Override
    protected KnowledgePresenter createPresenter() {
        return new KnowledgePresenter();
    }

    @Override
    public void getKnowledge(List<KnowledgeBean> knowledgeBeanList) {
        mKnowledgeAdapter.setNewData(knowledgeBeanList);
    }
}
