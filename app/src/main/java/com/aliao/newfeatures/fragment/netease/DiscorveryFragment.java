package com.aliao.newfeatures.fragment.netease;

import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * Created by ALiao on 2015/7/31.
 */
public class DiscorveryFragment extends Fragment {
    public static final String TAG = DiscorveryFragment.class.getSimpleName();

    public static DiscorveryFragment newInstance() {
        
        Bundle args = new Bundle();
        
        DiscorveryFragment fragment = new DiscorveryFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
