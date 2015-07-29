package com.aliao.newfeatures.activity.douban;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.aliao.newfeatures.R;
import com.aliao.newfeatures.adapter.douban.DoubanPagerAdapter;
import com.aliao.newfeatures.adapter.douban.DoubanRecyclerAdapter;

/**
 * Created by ALiao on 2015/7/28.
 */
public class DoubanMainActivity extends AppCompatActivity {

    private String[] mTabText = {"豆瓣", "发现" ,"圈子", "我的"};
    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private DoubanPagerAdapter mPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doubanmain);
        initInstances();
    }

    private void initInstances() {
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mTabLayout = (TabLayout) findViewById(R.id.tablayout);
        mPagerAdapter = new DoubanPagerAdapter(getSupportFragmentManager(),mTabText);
        mViewPager.setAdapter(mPagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }
}
