package com.wujie.mywanandroid.widget;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.wujie.mywanandroid.R;

/**
 * Created by HuangBin on 2018/12/1 16:46.
 * Description：
 */
public class StatusLayout extends FrameLayout {

    private View mContentView;
    private View mLoadingView;
    private View mEmptyView;
    private View mErrorView;

    public StatusLayout(@NonNull Context context) {
        this(context, null);
    }

    public StatusLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater inflater = LayoutInflater.from(context);
        mLoadingView = inflater.inflate(R.layout.view_loading, this, false);
        mEmptyView = inflater.inflate(R.layout.view_empty, this, false);
        mErrorView = inflater.inflate(R.layout.view_error, this, false);

        Button btnRetry = (Button) mErrorView.findViewById(R.id.btn_retry);
        btnRetry.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mOnRetryClickListener != null) {
                    mOnRetryClickListener.onRetryClick();
                }
            }
        });

        addView(mLoadingView);
        addView(mEmptyView);
        addView(mErrorView);
        mLoadingView.setVisibility(GONE);
        mErrorView.setVisibility(GONE);
        mEmptyView.setVisibility(GONE);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        if (changed) {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                mContentView = getChildAt(i);
                if (mContentView instanceof RecyclerView) {
                    break;
                }
            }
        }
    }

    public void setLoading() {
        mLoadingView.setVisibility(VISIBLE);
        mEmptyView.setVisibility(GONE);
        mErrorView.setVisibility(GONE);
        if (mContentView != null) {
            mContentView.setVisibility(GONE);
        }
    }

    public void setEmpty() {
        mLoadingView.setVisibility(GONE);
        mEmptyView.setVisibility(VISIBLE);
        mErrorView.setVisibility(GONE);
        if (mContentView != null) {
            mContentView.setVisibility(GONE);
        }
    }

    public void setError() {
        mLoadingView.setVisibility(GONE);
        mEmptyView.setVisibility(GONE);
        mErrorView.setVisibility(VISIBLE);
        if (mContentView != null) {
            mContentView.setVisibility(GONE);
        }
    }

    public void setContent() {
        mLoadingView.setVisibility(GONE);
        mEmptyView.setVisibility(GONE);
        mErrorView.setVisibility(GONE);
        if (mContentView != null) {
            mContentView.setVisibility(VISIBLE);
        }
    }

    public interface OnRetryClickListener {
        void onRetryClick();
    }

    private OnRetryClickListener mOnRetryClickListener;

    public void setOnRetryClickListener(OnRetryClickListener onRetryClickListener) {
        mOnRetryClickListener = onRetryClickListener;
    }

}
