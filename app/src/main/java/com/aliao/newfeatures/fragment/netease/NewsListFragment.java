package com.aliao.newfeatures.fragment.netease;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aliao.newfeatures.R;

/**
 * Created by ALiao on 2015/7/31.
 */
public class NewsListFragment extends Fragment {

    public static NewsListFragment newInstance() {

        Bundle args = new Bundle();

        NewsListFragment fragment = new NewsListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_netease_newslist, container, false);
    }
}
