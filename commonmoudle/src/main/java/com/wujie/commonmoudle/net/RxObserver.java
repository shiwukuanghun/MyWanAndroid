package com.wujie.commonmoudle.net;

import android.widget.Toast;

import com.google.gson.JsonParseException;
import com.wujie.commonmoudle.BaseApplication;
import com.wujie.commonmoudle.bean.BaseBean;
import com.wujie.commonmoudle.presenter.BasePresenter;
import com.wujie.commonmoudle.view.IBaseView;

import org.json.JSONException;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.text.ParseException;

import io.reactivex.observers.DisposableObserver;

/**
 * Created by HuangBin on 2018/11/16 19:40.
 * Description：
 */

public abstract class RxObserver<T> extends DisposableObserver<BaseBean<T>> {

    private final IBaseView mView;

    public RxObserver(BasePresenter presenter) {
        mView = presenter.getView();
    }

    @Override
    protected void onStart() {
        super.onStart();
        start();
        mView.showLoading("");
    }

    @Override
    public void onNext(BaseBean<T> value) {
        if (value.getErrorCode() == NetConfig.REQUEST_SUCCESS) {
            onSuccess(value.getData());
        } else {
            onFailure(value.getErrorCode(), value.getErrorMsg());
        }
    }

    @Override
    public void onError(Throwable e) {
        hideLoading();
        if (e instanceof ConnectException || e instanceof UnknownHostException) {
            //连接错误
            onException(NetConfig.CONNECT_ERROR);
        } else if (e instanceof InterruptedException) {
            //连接超时
            onException(NetConfig.REQUEST_TIMEOUT);
        } else if (e instanceof JsonParseException || e instanceof ParseException
                || e instanceof JSONException) {
            //解析异常
            onException(NetConfig.PARSE_ERROR);
        } else if (e instanceof SocketTimeoutException) {
            //请求超时
            onException(NetConfig.REQUEST_TIMEOUT);
        } else if (e instanceof UnknownError) {
            //未知错误
            onException(NetConfig.UNKNOWN_ERROR);
        } else {
            //未知错误
            onException(NetConfig.UNKNOWN_ERROR);
        }
        onFailure(-1, "网络异常");
    }

    @Override
    public void onComplete() {
        hideLoading();
    }

    private void hideLoading() {
        if (null != mView) {
            mView.hideLoading();
        }
    }

    private void onException(int errorCode) {
        switch (errorCode) {
            case NetConfig.CONNECT_ERROR:
                Toast.makeText(BaseApplication.getBaseApplication(), "网络异常", Toast.LENGTH_SHORT).show();
                break;
            case NetConfig.CONNECT_TIMEOUT:
                Toast.makeText(BaseApplication.getBaseApplication(), "连接超时", Toast.LENGTH_SHORT).show();
                break;
            case NetConfig.PARSE_ERROR:
                Toast.makeText(BaseApplication.getBaseApplication(), "解析错误", Toast.LENGTH_SHORT).show();
                break;
            case NetConfig.REQUEST_ERROR:
                Toast.makeText(BaseApplication.getBaseApplication(), "请求超时", Toast.LENGTH_SHORT).show();
                break;
            case NetConfig.UNKNOWN_ERROR:
                Toast.makeText(BaseApplication.getBaseApplication(), "未知错误", Toast.LENGTH_SHORT).show();
                break;

        }
    }

    protected abstract void start();

    protected abstract void onSuccess(T t);

    protected abstract void onFailure(int errorCode, String errorMsg);
}
