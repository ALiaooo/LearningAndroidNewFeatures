package com.aliao.newfeatures.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.aliao.newfeatures.R;
import com.aliao.newfeatures.adapter.TabPagerAdapter;

/**
 * Created by ALiao on 2015/7/28.
 * https://developer.android.com/reference/android/support/design/widget/TabLayout.html#setTabsFromPagerAdapter(android.support.v4.view.PagerAdapter)
 * http://blog.csdn.net/feiduclear_up/article/details/46500865
 * TabLayout
 * 1.设置颜色的属性：
 *  1.app:tabTextColor：Tab未被选中字体的颜色
 *  2.app:tabSelectedTextColor：Tab被选中字体的颜色
 *  3.app:tabIndicatorColor：Tab指示器下标的颜色
 *
 * 2.Tab Mode
 *  xml里设置app:tabMode
 *
 * 3.让TabLayout和Viewpager的关联一步到位的方法
 *  mTabLayout.setupWithViewPager(mViewPager);
 *  1.该方法实现了ViewPager.OnPagechangeListerner，将事件转发给TabLayout，即滑动viewPager内容页面，对应的tab跟着高亮
 *  2.从ViewPager的PagerAdapter中填充TabLayout的tabs。也就是说我们不再需要自己去addTab了（mTabLayout.addTab(mTabLayout.newTab()可以省了）
 *  3.设置TabLayout.OnTabSelectedListener方法，他会把tab的选中事件转达给ViewPager。也就是点击tab的时候，viewPager跳转到对应的内容页面
 *  用这个setupWithViewPager方法等于是一次性把三件事情都做了，省了不少代码
 *  代码中的simpleWay()和complicatedWay(）展示了TabLayout和ViewPager关联的两种实现方式
 *
 * 4.setTabsFromPagerAdapter(PagerAdapter adapter)的作用
 *  Populate our tab content from the given PagerAdapter.从给定的PagerAdapter填充tab的内容
 *  源码中就这么几行代码，先把已有的tab移除，然后从PagerAdapter中通过adapter.getCount()拿到要显示tab的个数去newTab，
 *  然后再通过aadapter.getPageTitle(i)去设置tab的text
 *      public void setTabsFromPagerAdapter(@NonNull PagerAdapter adapter) {
            this.removeAllTabs();
            int i = 0;

            for(int count = adapter.getCount(); i < count; ++i) {
                this.addTab(this.newTab().setText(adapter.getPageTitle(i)));
            }
        }
 *  所以设置了这个方法呢，也就省了我们自己去addTab了：mTabLayout.addTab(mTabLayout.newTab().setText(mTabs[i]));
 *
 */

public class TabLayoutActivity extends AppCompatActivity {

    private static final int TAB_COUNT = 4;

    private TabLayout mTabLayout;
    private String[] mTabs;
    private ViewPager mViewPager;
    private TabPagerAdapter mPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablayout);
        initTab();
        complicatedWay();
    }

    private void initTab() {
        mTabs = new String[TAB_COUNT];
        for (int i = 0; i < TAB_COUNT; i++){
            mTabs[i] = "Tab "+i;
        }
    }

    /**
     * 使用setupWithViewPager一步实现TabLayout与ViewPager的联动
     */
    private void  simpleWay() {
        mTabLayout = (TabLayout) findViewById(R.id.tablayout);
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mPagerAdapter = new TabPagerAdapter(getSupportFragmentManager(), mTabs);
        mViewPager.setAdapter(mPagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);//将TabLayout和ViewPager关联起来
    }

    /**
     * 没有使用setupWithViewPager的情况下，去实现TabLayout与ViewPager的联动
     */
    private void complicatedWay(){

        mTabLayout = (TabLayout) findViewById(R.id.tablayout);

//        for (int i = 0; i < mTabs.length; i++){
//            mTabLayout.addTab(mTabLayout.newTab().setText(mTabs[i]));
//        }

        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mPagerAdapter = new TabPagerAdapter(getSupportFragmentManager(), mTabs);
        mViewPager.setAdapter(mPagerAdapter);
        mTabLayout.setTabsFromPagerAdapter(mPagerAdapter);//给tab设置adapter,根据fragment的个数去newTab，并通过adapter.getPageTitle来设置tab的text

        mTabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        TabLayout.TabLayoutOnPageChangeListener listener = new TabLayout.TabLayoutOnPageChangeListener(mTabLayout);
        mViewPager.addOnPageChangeListener(listener);
    }
}
