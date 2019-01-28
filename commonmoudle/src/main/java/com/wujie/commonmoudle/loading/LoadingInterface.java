package com.wujie.commonmoudle.loading;

/**
 * Time：2019/1/26 0026 下午 16:54
 * Author：WuChen
 * Description：
 **/
public interface LoadingInterface {

    void showLoading();

    void showNetworkError();

    void showError();

    void showEmpty();

    void dismissLoading();

    interface OnClickListener {
        void onClick();
    }

}
