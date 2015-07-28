package com.aliao.newfeatures.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.aliao.newfeatures.R;
import com.aliao.newfeatures.adapter.CommonRecyclerAdapter;

/**
 * Created by ALiao on 2015/7/28.
 * CoordinatorLayout是一个超强的FrameLayout
 * 他主要的两个作用就是：
 * 1.作为应用的根布局 As a top-levelapplication decor or chrome layout
 * 2.作为子视图相互沟通的协调布局 As a container for a specific interaction with one or more child views
 *
 * CoordinatorLayout实现的滚动效果：
 * 1.扩展或收缩Toolbar或者头部空间，让内容区域有更多空间
 *   Toolbar在CoordinatorLayout中不能响应滚动事件，要做到响应事件：
 *      1>必须在外面包一个AppBarLayout
 *      2>需要定义AppBarLayout(CoordinatorLayout的一个子view即可)与滚动视图（例RecyclerView，NestedScrollView）的联系:
 *          1.在滚动视图上添加app:layout_behavior="@string/appbar_scrolling_view_behavior"
 *          2.在AppBarLayout上添加app:scrollFlags="scroll|enterAlways"（enterAlways:针对AppbarLayout进入时，只要滚动视图滚动了，AppbarLayout就立马显示。 exitUntilCollapsed和enterUntilCollapsed只有设置了minHeight的时候才有效果）
 *       当CoordinatorLayout发现了滚动视图中定义了layout_behavior这个属性，他会搜索自己包含的其他子view，看看是否有view与这个behavior想关联。
 *
 * 2.Creating Parallax Animations
 *  1>使用CollapsingToolbarLayout包裹ToolBar和其他子view
 *  2>使用app:layout_collapseMode="parallax"
 *
 * 3.Floating Action Buttons and Snackbars
 * CoordinatorLayout可以被用于创建浮动效果，当Sanckbars弹出/消失,FAB自动向上移动/向下回到原位，只有在CoordinatorLayout布局中，这种上下移的动画效果就会自动完成。
 */
public class CoordinatorLayoutActivity extends AppCompatActivity {

    private static final int DATASET_COUNT = 60;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private String[] mDataSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinator);

        initDataSet();
        initToolbar();
        initInstances();
    }

    private void initDataSet() {
        mDataSet = new String[DATASET_COUNT];
        for (int i = 0; i < DATASET_COUNT; i++){
            mDataSet[i] = "This is element #"+i;
        }
    }


    private void initToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private void initInstances() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new CommonRecyclerAdapter(mDataSet);
        mRecyclerView.setAdapter(mAdapter);

        final FloatingActionButton floatingActionButton = (FloatingActionButton) findViewById(R.id.floatingActionButton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(floatingActionButton, "FAB is clicked", Snackbar.LENGTH_SHORT).show();
            }
        });
    }

}
