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
public class NewsFragment extends Fragment{

    public static final String TAG = NewsFragment.class.getSimpleName();

    public static NewsFragment newInstance() {

        Bundle args = new Bundle();

        NewsFragment fragment = new NewsFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_netease_news, container, false);
        return v;
    }
}
