package com.wujie.commonmoudle.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wujie.commonmoudle.presenter.BasePresenter;
import com.wujie.commonmoudle.view.IBaseView;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Time：2019/1/11 0011 下午 14:01
 * Author：WuChen
 * Description：
 **/
public abstract class BaseFragment<P extends BasePresenter<V>, V extends IBaseView> extends Fragment implements IBaseView {

    protected P mPresenter;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), container, false);
        unbinder = ButterKnife.bind(this, view);
        mPresenter = createPresenter();
        attachView();
        init(view);
        return view;
    }

    protected abstract int getLayoutId();

    protected abstract void init(View view);

    private void attachView() {
        if (mPresenter != null) {
            mPresenter.attachView((V) this);
        }
    }

    private void detachView() {
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }

    protected abstract P createPresenter();

    @Override
    public void onDestroy() {
        super.onDestroy();
        detachView();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void showLoading(String msg) {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showError() {

    }

    @Override
    public void showFailure(String msg) {

    }

    @Override
    public void showEmpty() {

    }
}
