package com.aliao.newfeatures.activity.netease;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.aliao.newfeatures.R;

/**
 * Created by ALiao on 2015/7/30.
 */
public class NetEaseMainActivity extends AppCompatActivity {

    private TabLayout mTabLayout;
    private String[] mTabText = {"新闻", "阅读", "视听", "发现", "我"};
    private int mTabIconRes[] = {R.drawable.tab_news_selector, R.drawable.tab_read_selector, R.drawable.tab_va_selector, R.drawable.tab_discovery_selector, R.drawable.tab_pc_selector};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_netease_main);
        initInstances();
    }

    private void initInstances() {
        mTabLayout = (TabLayout) findViewById(R.id.tablayout);
        for (int i = 0; i < mTabText.length; i++){
            mTabLayout.addTab(mTabLayout.newTab().setCustomView(getTabView(i)));
        }
        mTabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
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
