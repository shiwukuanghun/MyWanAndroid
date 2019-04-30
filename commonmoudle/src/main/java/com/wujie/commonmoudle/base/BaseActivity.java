package com.wujie.commonmoudle.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.gyf.barlibrary.ImmersionBar;
import com.wind.me.xskinloader.SkinInflaterFactory;
import com.wind.me.xskinloader.SkinManager;
import com.wind.me.xskinloader.util.AssetFileUtils;
import com.wujie.commonmoudle.R;
import com.wujie.commonmoudle.loading.LoadingController;
import com.wujie.commonmoudle.loading.LoadingInterface;
import com.wujie.commonmoudle.presenter.BasePresenter;
import com.wujie.commonmoudle.view.IBaseView;

import java.io.File;

import butterknife.ButterKnife;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import me.imid.swipebacklayout.lib.app.SwipeBackActivity;

/**
 * Time：2019/1/11 0011 下午 14:01
 * Author：WuChen
 * Description：
 **/
public abstract class BaseActivity<P extends BasePresenter<V>, V extends IBaseView> extends SwipeBackActivity implements IBaseView  {

    protected P mPresenter;
    protected Context mContext;
    protected LoadingController mLoadingController;
    protected CompositeDisposable mCompositeDisposable;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        SkinInflaterFactory.setFactory(this);
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
//        setSwipeBackEnable(true);
        mContext = this;
        mPresenter = createPresenter();
        if (null != mPresenter) {
            mPresenter.attachView((V) this);
        }
        ImmersionBar.with(this).statusBarColor(R.color.yellow).init();
//        ImmersionBar.with(this).init();
        init();
    }

    protected abstract int getLayoutId();

    protected abstract P createPresenter();

    protected abstract void init();

    protected void initStatusBar(boolean isLightMode, int statusBarColor) {
        ImmersionBar.with(this)
                .statusBarDarkFont(isLightMode)
                .statusBarColor(statusBarColor)
                .init();
    }

    protected void addDisposable(Disposable disposable) {
        if (mCompositeDisposable == null) {
            mCompositeDisposable = new CompositeDisposable();
        }
        mCompositeDisposable.add(disposable);
    }

    protected void clearDisposable() {
        if (mCompositeDisposable != null) {
            mCompositeDisposable.clear();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        clearDisposable();
        if (null != mPresenter) {
            mPresenter.detachView();
        }
        ImmersionBar.with(this).destroy();
//        RefWatcher refWatcher = BaseApplication.getRefWatcher(this);
//        refWatcher.watch(this);
    }

    public void useNightMode(boolean isNight) {

        if (isNight) {
            changeSkin();

        } else {

            restoreDefaultSkin();
        }
    }

    private void changeSkin() {
        //将assets目录下的皮肤文件拷贝到data/data/.../cache目录下
        String saveDir = getCacheDir().getAbsolutePath() + "/skins";
        String savefileName = "/skin1.skin";
        String asset_dir = "skin/xskinloader-skin-apk-debug.apk";
        File file = new File(saveDir + File.separator + savefileName);
//        if (!file.exists()) {
        AssetFileUtils.copyAssetFile(this, asset_dir, saveDir, savefileName);
//        }
        SkinManager.get().loadNewSkin(file.getAbsolutePath());
    }

    private void restoreDefaultSkin() {
        SkinManager.get().restoreToDefaultSkin();
    }

    protected void initLoading(View view) {
        mLoadingController = new LoadingController.Builder(this, view)
//                .setLoadingImageResource(R.drawable.common_loading_frame_anim)
                .setLoadingMessage("加载中...")
                .setErrorMessage("网络不给力")
//                .setEmptyViewImageResource(getEmptyImg())
//                .setErrorImageResoruce(R.mipmap.net_error)
                .setEmptyMessage(getEmptyMsg())
                .setOnNetworkErrorRetryClickListener(new LoadingInterface.OnClickListener() {
                    @Override
                    public void onClick() {

                    }
                })
                .setOnErrorRetryClickListener("点我重试", new LoadingInterface.OnClickListener() {
                    @Override
                    public void onClick() {
                        retry();
                    }
                }) .setOnEmptyTodoClickListener(getEmptyTodoText(), new LoadingInterface.OnClickListener() {
                    @Override
                    public void onClick() {
                        emptyTodo();
                    }
                })
                .build();
    }

    protected void retry() {}

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

    protected boolean isEmpty(TextView textView) {
        return TextUtils.isEmpty(textView.getText().toString().trim());
    }

    protected String getText(TextView textView) {
        return textView.getText().toString().trim();
    }
}
