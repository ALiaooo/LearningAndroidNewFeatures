package com.aliao.newfeatures.activity.propertyanimation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.Keyframe;
import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;

import com.aliao.newfeatures.R;
import com.aliao.newfeatures.utils.L;

/**
 * Created by 丽双 on 2015/8/14.
 */
public class LayoutTransitionActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener{

    private LinearLayout mContainer;
    private int mValue;
    private CheckBox mCbAppearing, mCbChangeAppearing, mCbDisapearing, mCbChangeDisapearing, mCbChange, mCbCustom;
    private LayoutTransition mLayoutTransition;
    private Animator mCustonAppearingAnim, mCustomChangeAppearingAnim, mCustomDisappearingAnim, mCustomChangeDisappearingAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_animations);
        initInstances();
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private void initInstances() {
        mContainer = (LinearLayout) findViewById(R.id.container);
        mCbAppearing = (CheckBox) findViewById(R.id.cb_appearing);
        mCbChangeAppearing = (CheckBox) findViewById(R.id.cb_change_appearing);
        mCbDisapearing = (CheckBox) findViewById(R.id.cb_disappearing);
        mCbChangeDisapearing = (CheckBox) findViewById(R.id.cb_change_disappearing);
        mCbChange = (CheckBox) findViewById(R.id.cb_changeing);
        mCbCustom = (CheckBox) findViewById(R.id.cb_custom);
        mCbAppearing.setOnCheckedChangeListener(this);
        mCbChangeAppearing.setOnCheckedChangeListener(this);
        mCbDisapearing.setOnCheckedChangeListener(this);
        mCbChangeDisapearing.setOnCheckedChangeListener(this);
        mCbChange.setOnCheckedChangeListener(this);
        mCbCustom.setOnCheckedChangeListener(this);


        mLayoutTransition = new LayoutTransition();
        mContainer.setLayoutTransition(mLayoutTransition);
        createCustomAnim();
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private void createCustomAnim() {
        //Adding
        mCustonAppearingAnim = ObjectAnimator.ofFloat(null, "rotationY", 90f, 0f);
        mCustonAppearingAnim.setDuration(mLayoutTransition.getDuration(LayoutTransition.APPEARING));
        mCustonAppearingAnim.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                View view = (View) ((ObjectAnimator) animation).getTarget();
                view.setRotationY(0f);
            }
        });

        //Removing
//        mCustomDisappearingAnim = ObjectAnimator.ofFloat(null, "scaleX", 1f, 0f);
        mCustomDisappearingAnim = ObjectAnimator.ofFloat(null, "rotationX", 0f, 90f);//围绕X轴旋转，默认是0
        mCustomDisappearingAnim.setDuration(mLayoutTransition.getDuration(LayoutTransition.DISAPPEARING));
        mCustomDisappearingAnim.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                View view = (View) ((ObjectAnimator) animation).getTarget();
//                view.setScaleX(0f);
                view.setRotationX(0f);
            }
        });

        //Changing while Adding
        PropertyValuesHolder pvhLeft = PropertyValuesHolder.ofInt("left", 0, 1);
        PropertyValuesHolder pvhTop = PropertyValuesHolder.ofInt("top", 0, 1);
        PropertyValuesHolder pvhRight = PropertyValuesHolder.ofInt("right", 0, 1);
        PropertyValuesHolder pvhBottom = PropertyValuesHolder.ofInt("bottom", 0, 1);
        PropertyValuesHolder pvhScaleX = PropertyValuesHolder.ofFloat("scaleX", 1f, 0f, 1f);
        PropertyValuesHolder pvhScaleY = PropertyValuesHolder.ofFloat("scaleY", 1f, 0f, 1f);
        mCustomChangeAppearingAnim = ObjectAnimator.ofPropertyValuesHolder(this, pvhLeft, pvhTop, pvhRight, pvhBottom, pvhScaleX, pvhScaleY);
        mCustomChangeAppearingAnim.setDuration(mLayoutTransition.getDuration(LayoutTransition.CHANGE_APPEARING));
        mCustomChangeAppearingAnim.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                View view = (View) ((ObjectAnimator) animation).getTarget();
                view.setScaleX(1f);
                view.setScaleY(1f);
            }
        });

        //Changing while Removing
        Keyframe kf0 = Keyframe.ofFloat(0f, 0f);
        Keyframe kf1 = Keyframe.ofFloat(.9999f, 360f);
        Keyframe kf2 = Keyframe.ofFloat(1f, 0f);
        PropertyValuesHolder pvhRotation = PropertyValuesHolder.ofKeyframe("rotation", kf0, kf1, kf2);
        mCustomChangeDisappearingAnim = ObjectAnimator.ofPropertyValuesHolder(this, pvhLeft, pvhTop, pvhRight, pvhBottom, pvhRotation);
        mCustomChangeDisappearingAnim.setDuration(mLayoutTransition.getDuration(LayoutTransition.CHANGE_DISAPPEARING));
        mCustomChangeDisappearingAnim.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                View view = (View) ((ObjectAnimator) animation).getTarget();
                view.setRotation(0f);
            }
        });

    }

    public void onAddButton(View view){
        final Button button = new Button(this);
        button.setText((++mValue) + "");
        mContainer.addView(button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContainer.removeView(button);
            }
        });
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

        L.d("mCbAppearing.isChecked() = "+mCbAppearing.isChecked());
        L.d("mCbChangeAppearing.isChecked() = "+mCbChangeAppearing.isChecked());
        L.d("mCbDisapearing.isChecked() = "+mCbDisapearing.isChecked());
        L.d("mCbChangeDisapearing.isChecked() = "+mCbChangeDisapearing.isChecked());

        mLayoutTransition.setAnimator(LayoutTransition.APPEARING, mCbAppearing.isChecked() ? (mCbCustom.isChecked()?mCustonAppearingAnim:mLayoutTransition.getAnimator(LayoutTransition.APPEARING)):null);
        mLayoutTransition.setAnimator(LayoutTransition.CHANGE_APPEARING, mCbChangeAppearing.isChecked() ? (mCbCustom.isChecked()?mCustomChangeAppearingAnim:mLayoutTransition.getAnimator(LayoutTransition.CHANGE_APPEARING)):null);
        mLayoutTransition.setAnimator(LayoutTransition.DISAPPEARING, mCbDisapearing.isChecked() ?  (mCbCustom.isChecked()?mCustomDisappearingAnim:mLayoutTransition.getAnimator(LayoutTransition.DISAPPEARING)) : null);
        mLayoutTransition.setAnimator(LayoutTransition.CHANGE_DISAPPEARING, mCbChangeDisapearing.isChecked() ? (mCbCustom.isChecked()?mCustomChangeDisappearingAnim:mLayoutTransition.getAnimator(LayoutTransition.CHANGE_DISAPPEARING)) : null);
        mLayoutTransition.setAnimator(LayoutTransition.CHANGING, mCbChange.isChecked() ? mLayoutTransition.getAnimator(LayoutTransition.CHANGING) : null);
    }

}
