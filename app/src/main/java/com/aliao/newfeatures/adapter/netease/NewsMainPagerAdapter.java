package com.aliao.newfeatures.adapter.netease;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.aliao.newfeatures.fragment.netease.NewsListFragment;

/**
 * Created by ALiao on 2015/7/31.
 */
public class NewsMainPagerAdapter extends FragmentPagerAdapter {

    private String[] mTabs;

    public NewsMainPagerAdapter(FragmentManager fm, String[] tabs) {
        super(fm);
        mTabs = tabs;
    }

    @Override
    public Fragment getItem(int position) {
        return new NewsListFragment().newInstance();
    }

    @Override
    public int getCount() {
        return mTabs.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTabs[position];
    }
}
