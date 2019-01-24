package com.wujie.mywanandroid.ui.fragment.todo;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.wujie.commonmoudle.base.BaseFragment;
import com.wujie.mywanandroid.R;
import com.wujie.mywanandroid.adapter.WaitTodoAdapter;
import com.wujie.mywanandroid.bean.PageListDataBean;
import com.wujie.mywanandroid.bean.TodoBean;
import com.wujie.mywanandroid.bean.TodoSection;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

import butterknife.BindView;
import butterknife.Unbinder;

/**
 * Time：2019/1/23 0023 下午 15:15
 * Author：WuChen
 * Description：待办事项
 **/
public class WaitTodoFragment extends BaseFragment<WaitTodoPresenter, WaiteTodoContact.View> implements WaiteTodoContact.View {
    @BindView(R.id.rv_todo)
    RecyclerView mRvTodo;
    @BindView(R.id.srl)
    SmartRefreshLayout mSrl;
    Unbinder unbinder;
    private WaitTodoAdapter mWaitTodoAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_wait_todo;
    }

    @Override
    protected void init(View view) {
        List<TodoSection> todoSectionList = new ArrayList<>();
        mWaitTodoAdapter = new WaitTodoAdapter(R.layout.item_wait_todo, R.layout.item_wait_todo_header, todoSectionList);
        mRvTodo.setHasFixedSize(true);
        mRvTodo.setLayoutManager(new LinearLayoutManager(getContext()));
        mRvTodo.setAdapter(mWaitTodoAdapter);
        mPresenter.getTodoList(1,0, 0, 0, 4);
    }

    @Override
    protected WaitTodoPresenter createPresenter() {
        return new WaitTodoPresenter();
    }

    @Override
    public void getTodoListSuccess(PageListDataBean<TodoBean> pageListDataBean) {
        List<TodoSection> todoSectionList = new ArrayList<>();
        LinkedHashSet<String> headers = new LinkedHashSet<>();

        if (pageListDataBean.getDatas()!=null && pageListDataBean.getDatas().size()>0) {
            Toast.makeText(getContext(), "成功", Toast.LENGTH_SHORT).show();
            List<TodoBean> todoBeanList = pageListDataBean.getDatas();
            for(TodoBean todoBean : todoBeanList) {
                headers.add(todoBean.getDateStr());
            }
            for (String date : headers) {
                TodoSection headerSection = new TodoSection(true, date);
                todoSectionList.add(headerSection);
                for (TodoBean todoBean : todoBeanList) {
                    if (TextUtils.equals(date, todoBean.getDateStr())) {
                        TodoSection todoSection = new TodoSection(todoBean);
                        todoSectionList.add(todoSection);
                    }
                }
            }
            mWaitTodoAdapter.setNewData(todoSectionList);
        }
    }
}
