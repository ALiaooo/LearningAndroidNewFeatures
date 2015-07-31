package com.aliao.newfeatures.fragment.netease;

import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * Created by ALiao on 2015/7/31.
 */
public class VedioFragment extends Fragment {
    public static final String TAG = VedioFragment.class.getSimpleName();

    public static VedioFragment newInstance() {

        Bundle args = new Bundle();

        VedioFragment fragment = new VedioFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
