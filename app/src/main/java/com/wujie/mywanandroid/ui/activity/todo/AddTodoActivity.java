package com.wujie.mywanandroid.ui.activity.todo;

import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.gyf.barlibrary.ImmersionBar;
import com.wujie.commonmoudle.base.BaseActivity;
import com.wujie.commonmoudle.utils.ARouterUtils;
import com.wujie.mywanandroid.R;
import com.wujie.mywanandroid.bean.TodoBean;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Time：2019/1/23 0023 下午 14:10
 * Author：WuChen
 * Description：添加TODO界面
 **/
@Route(path = ARouterUtils.AddTodoPath)
public class AddTodoActivity extends BaseActivity<AddTodoPresenter, AddTodoContact.View> implements AddTodoContact.View {
    @BindView(R.id.view)
    View mView;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.btn_add)
    Button mBtnAdd;
    @BindView(R.id.et_title)
    EditText mEtTitle;
    @BindView(R.id.et_content)
    EditText mEtContent;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_add_todo;
    }

    @Override
    protected AddTodoPresenter createPresenter() {
        return new AddTodoPresenter();
    }

    @Override
    protected void init() {
        ImmersionBar.with(this)
                .transparentBar()
                .statusBarView(mView)
                .init();
    }

    @OnClick(R.id.btn_add)
    public void onViewClicked() {
        if (isEmpty(mEtTitle)) {
            Toast.makeText(mContext, "请输入标题", Toast.LENGTH_SHORT).show();
            return;
        }
        if (isEmpty(mEtContent)) {
            Toast.makeText(mContext, "请输入文本", Toast.LENGTH_SHORT).show();
        }
        mPresenter.addTodo(getText(mEtTitle),getText(mEtContent), "2019-01-23", 0, 1);
    }

    @Override
    public void addTodoSuccess(TodoBean todoBean) {
        Toast.makeText(mContext, "添加成功", Toast.LENGTH_SHORT).show();
    }
}
