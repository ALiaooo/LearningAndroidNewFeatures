package com.aliao.newfeatures.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.aliao.newfeatures.activity.fragment.TabContentFragment;


/**
 * Created by ALiao on 2015/7/28.
 */
public class TabPagerAdapter extends FragmentPagerAdapter {

    private String[] mTabs;

    public TabPagerAdapter(FragmentManager fm, String[] tabs) {
        super(fm);
        mTabs = tabs;
    }


    @Override
    public Fragment getItem(int position) {
        return TabContentFragment.newInstance("Tab "+position);
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
