package com.wujie.commonmoudle.presenter;


import com.wujie.commonmoudle.view.IBaseView;

import io.reactivex.disposables.Disposable;

/**
 * Created by HuangBin on 2018/11/16 12:17.
 * Description：
 */

public interface IPresenter<V extends IBaseView>  {

    void attachView(V v);

    void detachView();

    void checkAttachView();

    V getView();

    void addDisposable(Disposable disposable);

    void removeDisposable(Disposable disposable);

    void removeAllDisposable();

}
