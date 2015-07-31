package com.aliao.newfeatures.fragment.netease;

import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * Created by ALiao on 2015/7/31.
 */
public class MineFragment extends Fragment {

    public static final String TAG = MineFragment.class.getSimpleName();

    public static MineFragment newInstance() {
        
        Bundle args = new Bundle();
        
        MineFragment fragment = new MineFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
