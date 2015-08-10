package com.aliao.newfeatures.activity.propertyanimation;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.graphics.Path;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.aliao.newfeatures.R;
import com.aliao.newfeatures.utils.L;

/**
 * Created by 丽双 on 2015/8/10.
 * 属性动画
 */
public class PropertyAnimationActivity extends AppCompatActivity {

    private ImageView mIvMars;
    private ImageView mIvFemaleHead;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_animation);
        initInstances();
    }

    private void initInstances() {
        mIvMars = (ImageView) findViewById(R.id.iv_mars_circle);
        mIvFemaleHead = (ImageView) findViewById(R.id.iv_female_head);
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public void onClick(View view){

        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(mIvMars, "scaleX", 1f, 0.5f, 1f);
//        objectAnimator.ofFloat(mIvMars, "translationX", 100);
        objectAnimator.setDuration(500);
        objectAnimator.setRepeatCount(10);
        objectAnimator.setRepeatMode(ValueAnimator.REVERSE);
        objectAnimator.start();
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public void onValueAnimator(View view){

        ValueAnimator animator = ValueAnimator.ofInt(0, 10);
        animator.setDuration(500);
        animator.start();
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int cuttentValue = (int) animation.getAnimatedValue();
                L.d("cuttentValue =" + cuttentValue);
            }
        });
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public void onAlpha(View view){
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(mIvFemaleHead, "alpha", 1f, 0f, 1f);
        objectAnimator.setDuration(500);
        objectAnimator.start();

    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public void onRotation(View view){
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(mIvFemaleHead, "rotation", 0, 360);
        objectAnimator.setDuration(500);
        objectAnimator.start();
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public void onScale(View view){
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(mIvFemaleHead, "scaleX", 1f, 0.5f, 1f, 1.5f, 1f);
        objectAnimator.setDuration(500);
        objectAnimator.start();
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public void onTranslation(View view){
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(mIvFemaleHead, "translationX", 0f, 300f);
        objectAnimator.setDuration(500);
        objectAnimator.setRepeatCount(1);
        objectAnimator.setRepeatMode(ValueAnimator.REVERSE);
        objectAnimator.start();
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public void onAnimatorSet(View view){
        ObjectAnimator fadeInOut = ObjectAnimator.ofFloat(mIvFemaleHead, "alpha", 1f, 0f, 1f);
        fadeInOut.setDuration(2000);
        ObjectAnimator moveIn = ObjectAnimator.ofFloat(mIvFemaleHead, "translationX", -100f, 500f);
        moveIn.setDuration(2000);
        ObjectAnimator rotate = ObjectAnimator.ofFloat(mIvFemaleHead, "rotation", 0, 360);
        rotate.setDuration(2000);
        ObjectAnimator scale = ObjectAnimator.ofFloat(mIvFemaleHead, "scaleX", 1f, 0.8f, 1f, 1.2f, 1f);
        scale.setDuration(500);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(moveIn).with(rotate).before(scale).with(fadeInOut);
        animatorSet.start();
    }



}
