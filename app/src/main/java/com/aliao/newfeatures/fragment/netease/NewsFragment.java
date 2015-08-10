package com.aliao.newfeatures.fragment.netease;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.aliao.newfeatures.R;
import com.aliao.newfeatures.activity.netease.MainMoreMenuActivity;
import com.aliao.newfeatures.adapter.netease.NewsMainPagerAdapter;

/**
 * Created by ALiao on 2015/7/31.
 * 将Toolbar当作一个独立的控件来使用是不需要去掉actionbar的（两者可以共存），可以使用任意主题。
 * 但是在这种情况下，menu菜单并不会自动的显示在Toolbar上，Toolbar也不会响应菜单的回调函数，
 * 如果你想让menu菜单项显示在Toolbar上，必须手动inflate menu
 * http://www.jcodecraeer.com/a/anzhuokaifa/androidkaifa/2014/1107/1925.html
 */
public class NewsFragment extends Fragment implements View.OnClickListener {

    public static final String TAG = NewsFragment.class.getSimpleName();
    private static final int TAB_COUNT = 10;

    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private NewsMainPagerAdapter mPagerAdapter;
    private String[] mTabs = {"头条", "北京", "影视","移动互联","博客","论坛","热点","段子","娱乐","直播"};

    public static NewsFragment newInstance() {

        Bundle args = new Bundle();

        NewsFragment fragment = new NewsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        initDataSet();
    }

    private void initDataSet() {
        mTabs = new String[TAB_COUNT];
        for (int i = 0; i < TAB_COUNT; i++){
            mTabs[i] = "Tab "+i;
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_netease_news, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initToolbar(view);
        mTabLayout = (TabLayout) view.findViewById(R.id.tablayout);
        mViewPager = (ViewPager) view.findViewById(R.id.viewpager);
        mPagerAdapter = new NewsMainPagerAdapter(getFragmentManager(), mTabs);
        mViewPager.setAdapter(mPagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
        LinearLayout columnBg = (LinearLayout) view.findViewById(R.id.layout_column_edit_bg);
        columnBg.setOnClickListener(this);

    }

    private void initToolbar(final View view) {
        final Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        toolbar.setLogo(R.mipmap.logo);
        toolbar.inflateMenu(R.menu.netease_news_menu);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.action_news:
                        Snackbar.make(toolbar, "24小时要闻", Snackbar.LENGTH_SHORT).show();
                        break;
                    case R.id.action_more:
                        startActivity(new Intent(getActivity(), MainMoreMenuActivity.class));
                        Snackbar.make(toolbar, "更多", Snackbar.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.layout_column_edit_bg:

                break;
        }
    }
}
