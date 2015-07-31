package com.aliao.newfeatures.activity.netease;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.aliao.newfeatures.R;
import com.aliao.newfeatures.fragment.netease.DiscorveryFragment;
import com.aliao.newfeatures.fragment.netease.MineFragment;
import com.aliao.newfeatures.fragment.netease.NewsFragment;
import com.aliao.newfeatures.fragment.netease.ReadFragment;
import com.aliao.newfeatures.fragment.netease.VedioFragment;


/**
 * Created by ALiao on 2015/7/30.
 */
public class NetEaseMainActivity extends AppCompatActivity {

    private final int NES_FRAGMENT_INDEX = 0;
    private final int READ_FRAGMENT_INDEX = 1;
    private final int VEDIO_FRAGMENT_INDEX = 2;
    private final int DISCOVERY_FRAGMENT_INDEX = 3;
    private final int MINE_FRAGMENT_INDEX = 4;

    private TabLayout mTabLayout;
    private String[] mTabText = {"新闻", "阅读", "视听", "发现", "我"};
    private int mTabIconRes[] = {R.drawable.tab_news_selector, R.drawable.tab_read_selector, R.drawable.tab_va_selector, R.drawable.tab_discovery_selector, R.drawable.tab_pc_selector};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_netease_main);
        initInstances();
        replaceFrgment(NES_FRAGMENT_INDEX);
    }

    private void initInstances() {
        mTabLayout = (TabLayout) findViewById(R.id.tablayout);

        for (int i = 0; i < mTabText.length; i++){
            mTabLayout.addTab(mTabLayout.newTab().setCustomView(getTabView(i)));
        }

        mTabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                replaceFrgment(position);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

    }

    private void replaceFrgment(int position) {
        Fragment fragment = null;
        switch (position){
            case NES_FRAGMENT_INDEX:
                fragment = NewsFragment.newInstance();
                break;
            case READ_FRAGMENT_INDEX:
                fragment = ReadFragment.newInstance();
                break;
            case VEDIO_FRAGMENT_INDEX:
                fragment = VedioFragment.newInstance();
                break;
            case DISCOVERY_FRAGMENT_INDEX:
                fragment = DiscorveryFragment.newInstance();
                break;
            case MINE_FRAGMENT_INDEX:
                fragment = MineFragment.newInstance();
                break;
        }
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.commit();
    }


    private View getTabView(int index){
        View v = LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        ImageView tabIcon = (ImageView) v.findViewById(R.id.iv_tab_icon);
        TextView tabText = (TextView) v.findViewById(R.id.tv_tab_text);
        tabText.setText(mTabText[index]);
        tabIcon.setImageResource(mTabIconRes[index]);
        return v;
    }
}
