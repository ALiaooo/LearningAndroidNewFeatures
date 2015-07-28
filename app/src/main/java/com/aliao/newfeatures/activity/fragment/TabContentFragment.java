package com.aliao.newfeatures.activity.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.aliao.newfeatures.R;

/**
 * Created by ALiao on 2015/7/28.
 */
public class TabContentFragment extends Fragment {

    private static final String ARG_PARAM = "arg_param";

    private String content;

    public static TabContentFragment newInstance(String content) {
        Bundle args = new Bundle();
        args.putString(ARG_PARAM, content);
        TabContentFragment fragment = new TabContentFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null){
            content = getArguments().getString(ARG_PARAM);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_tabcontent, container, false);
        TextView textView = (TextView) v.findViewById(R.id.tvContent);
        textView.setText(content);
        return v;
    }
}
