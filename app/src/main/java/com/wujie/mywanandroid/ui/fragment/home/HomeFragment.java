package com.wujie.mywanandroid.ui.fragment.home;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.alibaba.android.arouter.launcher.ARouter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.ms.banner.Banner;
import com.ms.banner.BannerConfig;
import com.ms.banner.holder.BannerViewHolder;
import com.ms.banner.holder.HolderCreator;
import com.wujie.commonmoudle.GlideApp;
import com.wujie.commonmoudle.base.BaseFragment;
import com.wujie.commonmoudle.utils.ARouterUtils;
import com.wujie.commonmoudle.utils.Constant;
import com.wujie.mywanandroid.R;
import com.wujie.mywanandroid.adapter.HomeAdapter;
import com.wujie.mywanandroid.bean.BannerBean;
import com.wujie.mywanandroid.bean.HomeBean;
import com.wujie.mywanandroid.bean.PageListDataBean;
import com.wujie.mywanandroid.widget.StatusLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Time：2019/1/14 0014 上午 9:41
 * Author：WuChen
 * Description：首页
 **/
public class HomeFragment extends BaseFragment<HomePresenter, HomeContact.View> implements HomeContact.View {
    @BindView(R.id.rv_home)
    RecyclerView mRvHome;
    @BindView(R.id.status_layout)
    StatusLayout mStatusLayout;
    private HomeAdapter mHomeAdapter;
    private List<HomeBean> mDataList;
    private Banner mBanner;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void init(View view) {
        mDataList = new ArrayList<>();
        mRvHome.setHasFixedSize(true);
        mRvHome.setLayoutManager(new LinearLayoutManager(getContext()));
        mHomeAdapter = new HomeAdapter(R.layout.item_home, mDataList);
        mRvHome.setAdapter(mHomeAdapter);
        initBanner();

        mHomeAdapter.setOnItemChildClickListener((adapter, view12, position) -> mPresenter.collectOrUnCollectArticle(mHomeAdapter.getData().get(position).getId(), position));

        mHomeAdapter.setOnItemClickListener((adapter, view1, position) -> ARouter.getInstance().build(ARouterUtils.WebViewPath).withString(Constant.WebUrl, mHomeAdapter.getData().get(position).getLink()).navigation());

        mStatusLayout.setOnRetryClickListener(() -> {
            mPresenter.getHomeList(0);
            Toast.makeText(getContext(), "点击重连", Toast.LENGTH_SHORT).show();
        });
        mPresenter.getHomeList(0);
    }

    private void initBanner() {
        View bannerView = LayoutInflater.from(getContext()).inflate(R.layout.home_banner, null);
        mBanner = (Banner) bannerView.findViewById(R.id.banner);
        mHomeAdapter.addHeaderView(bannerView);
        mPresenter.getBanner();
    }

    @Override
    protected HomePresenter createPresenter() {
        return new HomePresenter();
    }

    @Override
    public void loadHomeFail(String msg) {
        mStatusLayout.setError();
    }

    @Override
    public void loadHomeData(PageListDataBean<HomeBean> pageListDataBean) {
        mStatusLayout.setContent();
        List<HomeBean> homeBeans = pageListDataBean.getDatas();
        mDataList.clear();
        mDataList.addAll(homeBeans);
        mHomeAdapter.notifyDataSetChanged();
    }

    @Override
    public void collectOrUnCollect(int position) {
        boolean isCollect = mHomeAdapter.getData().get(position).isCollect();
        mHomeAdapter.getData().get(position).setCollect(!isCollect);
        mHomeAdapter.notifyItemChanged(position, "payload");
    }

    @Override
    public void collectFailure(String msg) {
        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void getBannerSuccess(List<BannerBean> bannerBeanList) {
        if (bannerBeanList != null && bannerBeanList.size() > 0) {
            List<String> uriList = new ArrayList<>();
            for (int i = 0; i < bannerBeanList.size(); i++) {
                uriList.add(bannerBeanList.get(i).getImagePath());
            }
            mBanner.setPages(uriList, () -> new CustomViewHolder())
                    .setAutoPlay(true)
                    .setBannerStyle(BannerConfig.CUSTOM_INDICATOR)
                    .start();
        }
    }

    class CustomViewHolder implements BannerViewHolder<String> {

        private ImageView mIvBanner;

        @Override
        public View createView(Context context) {
            View view = LayoutInflater.from(context).inflate(R.layout.banner_item, null);
            mIvBanner = (ImageView) view.findViewById(R.id.iv_banner);
            return view;
        }

        @Override
        public void onBind(Context context, int position, String data) {
            // 数据绑定
            GlideApp.with(getContext()).load(data).centerCrop().into(mIvBanner);
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        //开始轮播
        mBanner.startAutoPlay();
    }

    @Override
    public void onStop() {
        super.onStop();
        //结束轮播
        mBanner.stopAutoPlay();
    }
}
