package com.wujie.commonmoudle.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.wujie.commonmoudle.R;
import com.wujie.commonmoudle.loading.LoadingController;
import com.wujie.commonmoudle.loading.LoadingInterface;
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
    protected LoadingController mLoadingController;
    private View mView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(getLayoutId(), container, false);
        unbinder = ButterKnife.bind(this, mView);
//        initLoading();
        mPresenter = createPresenter();
        attachView();
        init(mView);
        return mView;
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
//        RefWatcher refWatcher = BaseApplication.getRefWatcher(getActivity());
//        refWatcher.watch(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    protected void initLoading(View view) {
        mLoadingController = new LoadingController.Builder(getContext(), view)
                .setLoadingImageResource(R.drawable.loading_frame_anim)
                .setLoadingMessage("加载中...")
                .setErrorMessage("网络不给力")
//                .setEmptyViewImageResource(getEmptyImg())
//                .setErrorImageResoruce(R.mipmap.net_error)
                .setEmptyMessage(getEmptyMsg())
                .setOnNetworkErrorRetryClickListener(() -> {

                })
                .setOnErrorRetryClickListener("点我重试", () -> retry())
                .setOnEmptyTodoClickListener(getEmptyTodoText(), () -> emptyTodo())
                .build();
    }

    protected View loadingContent() {
        return mView;
    }

    protected void retry(){}

    protected String getEmptyMsg() {
        return "未找到相关内容";
    }

//    protected int getEmptyImg(){
//        return R.mipmap.search_empty;
//    }

    protected String getEmptyTodoText() {
        return null;
    }

    protected void emptyTodo() {}

    @Override
    public void showLoading(String msg) {
        mLoadingController.showLoading();
    }

    @Override
    public void hideLoading() {
        mLoadingController.dismissLoading();
    }

    @Override
    public void showError() {
        mLoadingController.showError();
    }

    @Override
    public void showFailure(String msg) {
        mLoadingController.showNetworkError();
    }

    @Override
    public void showEmpty() {
        mLoadingController.showEmpty();
    }
}
