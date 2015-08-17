package com.aliao.newfeatures.activity.netease;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

import com.aliao.newfeatures.R;

/**
 * Created by ALiao on 2015/8/10.
 */
public class MainMoreMenuActivity extends AppCompatActivity{

    private LinearLayout mRootLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_more_menu);
        mRootLayout = (LinearLayout) findViewById(R.id.rootLayout);
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(mRootLayout, "scaleY", 1.2f, 1.0f).setDuration(300);
        objectAnimator.start();
    }
}
