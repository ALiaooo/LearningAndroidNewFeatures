package com.aliao.newfeatures.fragment.netease;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aliao.newfeatures.R;

/**
 * Created by ALiao on 2015/7/31.
 */
public class ReadFragment extends Fragment {
    public static final String TAG = ReadFragment.class.getSimpleName();

    public static ReadFragment newInstance() {

        Bundle args = new Bundle();
        ReadFragment fragment = new ReadFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_netease_read, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initToolbar(view);
    }

    private void initToolbar(View view) {
        final Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);

    }
}
