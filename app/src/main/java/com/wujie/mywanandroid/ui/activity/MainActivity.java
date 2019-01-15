package com.wujie.mywanandroid.ui.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.wujie.commonmoudle.base.BaseActivity;
import com.wujie.commonmoudle.presenter.BasePresenter;
import com.wujie.mywanandroid.R;
import com.wujie.mywanandroid.ui.fragment.project.ProjectFragment;
import com.wujie.mywanandroid.ui.fragment.home.HomeFragment;
import com.wujie.mywanandroid.ui.fragment.knowledge.KnowledgeFragment;
import com.wujie.mywanandroid.ui.fragment.mine.MineFragment;
import com.wujie.mywanandroid.ui.fragment.NavigationFragment;

import butterknife.BindView;

public class MainActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener {

    @BindView(R.id.fl_container)
    FrameLayout mFlContainer;
    @BindView(R.id.rb_home)
    RadioButton mRbHome;
    @BindView(R.id.rb_knowledge)
    RadioButton mRbKnowledge;
    @BindView(R.id.rb_navigation)
    RadioButton mRbNavigation;
    @BindView(R.id.rb_mine)
    RadioButton mRbMine;
    @BindView(R.id.rg_container)
    RadioGroup mRgContainer;

    private HomeFragment mHomeFragment;
    private KnowledgeFragment mKnowledgeFragment;
    private NavigationFragment mNavigationFragment;
    private ProjectFragment mProjectFragment;
    private MineFragment mMineFragment;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected void init() {
        mRgContainer.setOnCheckedChangeListener(this);
        mRgContainer.check(R.id.rb_home);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        hideAllFragment(transaction);
        switch (checkedId) {
            case R.id.rb_home:
                if (mHomeFragment == null) {
                    mHomeFragment = new HomeFragment();
                    transaction.add(R.id.fl_container, mHomeFragment, "0");
                } else {
                    transaction.show(mHomeFragment);
                }
//                initStatusBar(false, R.color.colorPrimary);
                break;
            case R.id.rb_knowledge:
                if (mKnowledgeFragment == null) {
                    mKnowledgeFragment = new KnowledgeFragment();
                    transaction.add(R.id.fl_container, mKnowledgeFragment, "1");
                } else {
                    transaction.show(mKnowledgeFragment);
                }
//                initStatusBar(false, R.color.blue);
                break;
            case R.id.rb_navigation:
                if (mNavigationFragment == null) {
                    mNavigationFragment = new NavigationFragment();
                    transaction.add(R.id.fl_container, mNavigationFragment, "2");
                } else {
                    transaction.show(mNavigationFragment);
                }
                break;
            case R.id.rb_project:
                if (mProjectFragment == null) {
                    mProjectFragment = new ProjectFragment();
                    transaction.add(R.id.fl_container, mProjectFragment, "3");
                } else {
                    transaction.show(mProjectFragment);
                }
                break;
            case R.id.rb_mine:
                if (mMineFragment == null) {
                    mMineFragment = new MineFragment();
                    transaction.add(R.id.fl_container, mMineFragment, "4");
                } else {
                    transaction.show(mMineFragment);
                }
//                initStatusBar(true, R.color.yellow);
                break;
        }
        transaction.commit();
    }

    private void hideAllFragment(FragmentTransaction transaction) {
        if (mHomeFragment != null) {
            transaction.hide(mHomeFragment);
        }
        if (mKnowledgeFragment != null) {
            transaction.hide(mKnowledgeFragment);
        }
        if (mNavigationFragment != null) {
            transaction.hide(mNavigationFragment);
        }
        if (mProjectFragment !=null){
            transaction.hide(mProjectFragment);
        }
        if (mMineFragment != null) {
            transaction.hide(mMineFragment);
        }
    }

    @Override
    public void onAttachFragment(Fragment fragment) {//解决Fragment重影问题
        super.onAttachFragment(fragment);
        if (mHomeFragment == null && fragment instanceof HomeFragment) {
            mHomeFragment = (HomeFragment) fragment;
            getSupportFragmentManager().beginTransaction().hide(mHomeFragment).commit();
        } else if (mKnowledgeFragment == null && fragment instanceof KnowledgeFragment) {
            mKnowledgeFragment = (KnowledgeFragment) fragment;
            getSupportFragmentManager().beginTransaction().hide(mKnowledgeFragment).commit();
        } else if (mNavigationFragment == null && fragment instanceof  NavigationFragment) {
            mNavigationFragment = (NavigationFragment) fragment;
            getSupportFragmentManager().beginTransaction().hide(mNavigationFragment).commit();
        } else if (mProjectFragment == null && fragment instanceof ProjectFragment) {
            mProjectFragment = (ProjectFragment) fragment;
            getSupportFragmentManager().beginTransaction().hide(mProjectFragment).commit();
        }else if (mMineFragment == null && fragment instanceof MineFragment) {
            mMineFragment = (MineFragment) fragment;
            getSupportFragmentManager().beginTransaction().hide(mMineFragment).commit();
        }
    }

}
