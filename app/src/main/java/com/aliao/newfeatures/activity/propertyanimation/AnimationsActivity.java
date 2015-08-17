package com.aliao.newfeatures.activity.propertyanimation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.aliao.newfeatures.R;

/**
 * Created by 丽双 on 2015/8/14.
 */
public class AnimationsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
    }

    public void onPropertyAnim(View view){
        startActivity(new Intent(this, PropertyAnimationActivity.class));
    }
    public void onLayoutAnim(View view){
        startActivity(new Intent(this, LayoutTransitionActivity.class));
    }

    public void onActivityTransitionAnim(View view){
        Intent intent = new Intent(this, ActivityTransitionActivity.class);
        ActivityOptionsCompat options = ActivityOptionsCompat.makeScaleUpAnimation(view, 0,
                0, view.getWidth(), view.getHeight());
        ActivityCompat.startActivity(this, intent, options.toBundle());
    }
}
