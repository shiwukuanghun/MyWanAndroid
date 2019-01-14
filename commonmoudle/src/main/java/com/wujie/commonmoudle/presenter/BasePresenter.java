package com.wujie.commonmoudle.presenter;



import com.wujie.commonmoudle.view.IBaseView;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by HuangBin on 2018/11/16 12:25.
 * Description：
 */

public class BasePresenter<V extends IBaseView> implements IPresenter<V> {
    protected V mV;
    private CompositeDisposable mCompositeDisposable;

    @Override
    public void attachView(V v) {
        mV = v;
    }

    @Override
    public void detachView() {
         mV = null;
    }

    @Override
    public void checkAttachView() {
        if (mV == null) {
            throw new RuntimeException("You have not bind this view");
        }
    }

    @Override
    public V getView() {
        return mV;
    }

    @Override
    public void addDisposable(Disposable disposable) {
        if (mCompositeDisposable==null) {
            mCompositeDisposable = new CompositeDisposable();
        }
        mCompositeDisposable.add(disposable);
    }

    @Override
    public void removeDisposable(Disposable disposable) {
        if (mCompositeDisposable!=null) {
            mCompositeDisposable.remove(disposable);
        }
    }

    @Override
    public void removeAllDisposable() {
        if (mCompositeDisposable!=null) {
            mCompositeDisposable.clear();
        }
    }
}
