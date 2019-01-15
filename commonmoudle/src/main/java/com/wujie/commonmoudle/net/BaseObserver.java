package com.wujie.commonmoudle.net;

import android.text.TextUtils;
import android.widget.Toast;

import com.wujie.commonmoudle.BaseApplication;

import io.reactivex.observers.ResourceObserver;
import retrofit2.HttpException;

public abstract class BaseObserver<T> extends ResourceObserver<T> {

    private String errorMsg;
    private boolean isShowErrorView;

    public BaseObserver(){
    }

    public BaseObserver(String errorMsg){
        this.errorMsg = errorMsg;
    }


    public BaseObserver(String errorMsg,boolean isShowErrorView){
        this.errorMsg = errorMsg;
        this.isShowErrorView = isShowErrorView;
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    public void onComplete() {

    }

    @Override
    public void onError(Throwable e) {
        if(!TextUtils.isEmpty(errorMsg)){
//            Toast.makeText(BaseApplication.getBaseApplication(), errorMsg, Toast.LENGTH_SHORT).show();
            onFailure(-1, errorMsg);
        }/*else if(e instanceof ApiException){
            Toast.makeText(mContext, ((ApiException) e).getMsg(), Toast.LENGTH_SHORT).show();
        }*/else if(e instanceof HttpException){
//            Toast.makeText(BaseApplication.getBaseApplication(), "网络异常", Toast.LENGTH_SHORT).show();
            onFailure(-1, "网络异常");
        }else if (e instanceof OtherException) {
            Toast.makeText(BaseApplication.getBaseApplication(), e.getMessage(), Toast.LENGTH_SHORT).show();
            onFailure(((OtherException) e).getErrorCode(), e.getMessage());
        }else {
//            Toast.makeText(BaseApplication.getBaseApplication(), "未知错误", Toast.LENGTH_SHORT).show();
            onFailure(-1, "未知错误");
        }
    }

    @Override
    public void onNext(T t) {
        onSuccess(t);
    }

    protected abstract void start();

    protected abstract void onSuccess(T t);

    protected abstract void onFailure(int errorCode, String errorMsg);

}
