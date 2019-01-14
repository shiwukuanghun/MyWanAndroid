package com.wujie.commonmoudle.view;

/**
 * Created by HuangBin on 2018/11/16 12:09.
 * Description：
 */

public interface IBaseView {

    /**
     * 显示进度条
     * @param msg
     */
    void showLoading(String msg);

    /**
     * 隐藏进度条
     */
    void hideLoading();

    void showError();

    void showFailure(String msg);

    void showEmpty();

}
