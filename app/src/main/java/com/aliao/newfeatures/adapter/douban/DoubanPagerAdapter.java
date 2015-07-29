package com.aliao.newfeatures.adapter.douban;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by ALiao on 2015/7/29.
 */
public class DoubanPagerAdapter extends FragmentPagerAdapter {

    private String[] mTabText;
    private List<Fragment> mFragmentList;

    public DoubanPagerAdapter(FragmentManager fm, String[] tabText) {
        super(fm);
        mTabText = tabText;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mTabText.length;
    }
}
