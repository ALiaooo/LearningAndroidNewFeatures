package com.aliao.newfeatures.fragment.douban;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aliao.newfeatures.R;
import com.aliao.newfeatures.adapter.douban.DoubanRecyclerAdapter;

/**
 * Created by ALiao on 2015/7/29.
 */
public class MainFragment extends Fragment {

    private static final int ITEM_COUNT = 20;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private String[] mDataset;

    public static MainFragment newInstance() {

        Bundle args = new Bundle();

        MainFragment fragment = new MainFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDataSet();
    }

    private void initDataSet() {
        mDataset = new String[ITEM_COUNT];
        for (int i = 0; i < ITEM_COUNT; i++){
            mDataset[i] = "Element #"+i;
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_douban_main, container, false);
        mRecyclerView = (RecyclerView) v.findViewById(R.id.recyclerview);

        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new DoubanRecyclerAdapter(mDataset);
        mRecyclerView.setAdapter(mAdapter);
        return v;
    }

    

}
