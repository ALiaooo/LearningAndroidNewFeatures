package com.aliao.newfeatures.activity.propertyanimation;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.aliao.newfeatures.R;

/**
 * Created by 丽双 on 2015/8/10.
 * 属性动画:
 * ObjectAnimation的使用
 * 1.java代码实现动效
 * 2.xml中实现动效
 */
public class PropertyAnimationActivity extends AppCompatActivity {

    private ImageView mIvFemaleHead;
    private CheckBox mCheckBox;
    private LinearLayout mContainerLayout;
    private boolean isUseAnimationRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_animation);
        initInstances();
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private void initInstances() {
        mIvFemaleHead = (ImageView) findViewById(R.id.iv_female_head);
        mContainerLayout = (LinearLayout) findViewById(R.id.container);
        mCheckBox = (CheckBox) findViewById(R.id.checkbox);
        mCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isUseAnimationRes = isChecked;
            }
        });

        Button alphaBtn = (Button) findViewById(R.id.btn_alpha);
        Button rotationBtn = (Button) findViewById(R.id.btn_rotation);
        Button scaleBtn = (Button) findViewById(R.id.btn_scale);
        Button translationXBtn = (Button) findViewById(R.id.btn_translationx);
        Button translationBtn = (Button) findViewById(R.id.btn_translation);
        Button bgColorBtn = (Button) findViewById(R.id.btn_bgcolor);
        Button sequentialAnimatorBtn = (Button) findViewById(R.id.btn_sequential_animatorset);
        Button animatorBtn = (Button) findViewById(R.id.btn_animatorset);

        //透明度
        ObjectAnimator alphaAnimator = ObjectAnimator.ofFloat(mIvFemaleHead, "alpha", 1f, 0f, 1f);
        alphaAnimator.setDuration(500);
        setUpAnimation(alphaBtn,alphaAnimator, R.animator.alpha_girl_head, mIvFemaleHead);

        //旋转
        ObjectAnimator rotationAnimator = ObjectAnimator.ofFloat(mIvFemaleHead, "rotation", 0, 360);
        rotationAnimator.setDuration(500);
        setUpAnimation(rotationBtn, rotationAnimator, R.animator.rotation_girl_head, mIvFemaleHead);

        //缩放
        ObjectAnimator scaleAnimator = ObjectAnimator.ofFloat(mIvFemaleHead, "scaleX", 1f, 0.5f, 1f, 1.5f, 1f);
        scaleAnimator.setDuration(500);
        setUpAnimation(scaleBtn, scaleAnimator, R.animator.scale_girl_head, mIvFemaleHead);

        //平移
        ObjectAnimator translationXAnimator = ObjectAnimator.ofFloat(mIvFemaleHead, "translationX", 0f, 300f);
        translationXAnimator.setRepeatCount(1);
        translationXAnimator.setRepeatMode(ValueAnimator.REVERSE);
        translationXAnimator.setDuration(500);
        setUpAnimation(translationXBtn, translationXAnimator, R.animator.translationx_girl_head, mIvFemaleHead);

        //同时平移x和y
        PropertyValuesHolder tranX = PropertyValuesHolder.ofFloat("translationX", 0f, 300f);
        PropertyValuesHolder tranY = PropertyValuesHolder.ofFloat("translationY", 0f, 300f);
        ObjectAnimator translationAnimator = ObjectAnimator.ofPropertyValuesHolder(mIvFemaleHead, tranX, tranY);
        translationAnimator.setRepeatCount(1);
        translationAnimator.setRepeatMode(ValueAnimator.REVERSE);
        translationAnimator.setDuration(1000);
        setUpAnimation(translationBtn, translationAnimator, R.animator.translation_girl_head, mIvFemaleHead);

        //背景颜色
        final ObjectAnimator bgColorAnimator = ObjectAnimator.ofInt(mContainerLayout, "backgroundColor", R.color.animator_color_first, R.color.animator_color_second);
        bgColorAnimator.setDuration(1000);
        bgColorAnimator.setRepeatCount(1);
        bgColorAnimator.setRepeatMode(ValueAnimator.REVERSE);
//        setUpAnimation(bgColorBtn, bgColorAnimator, R.animator.bgcolor_animator, mContainerLayout);
        bgColorBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isUseAnimationRes){
                    ObjectAnimator objectAnimator = (ObjectAnimator) AnimatorInflater.loadAnimator(PropertyAnimationActivity.this, R.animator.bgcolor_animator);
                    objectAnimator.setEvaluator(new ArgbEvaluator());
                    objectAnimator.setTarget(mContainerLayout);
                    objectAnimator.start();
                }else {
                    bgColorAnimator.start();
                }
            }
        });

        //组合动画，将以上动画用动画集合顺序播放
        AnimatorSet sequentialAnimatorSet = new AnimatorSet();
        sequentialAnimatorSet.playSequentially(alphaAnimator, rotationAnimator, scaleAnimator, translationXAnimator);
        setUpAnimation(sequentialAnimatorBtn, sequentialAnimatorSet, R.animator.sequential_animatorset_girl_head, mIvFemaleHead);

        //组合动画，set嵌套set

        ObjectAnimator rotation = ObjectAnimator.ofFloat(mIvFemaleHead, "rotation", 0f, 360f);
        ObjectAnimator alpha = ObjectAnimator.ofFloat(mIvFemaleHead, "alpha", 1f, 0f, 1f);
        ObjectAnimator translationX = ObjectAnimator.ofFloat(mIvFemaleHead, "translationX", 0f, 300f);
        translationX.setRepeatCount(1);
        translationX.setRepeatMode(ValueAnimator.REVERSE);
        ObjectAnimator translationY = ObjectAnimator.ofFloat(mIvFemaleHead, "translationY", 0f, 300f);
        translationY.setRepeatCount(1);
        translationY.setRepeatMode(ValueAnimator.REVERSE);

        AnimatorSet animatorSet1 = new AnimatorSet();
        animatorSet1.playTogether(translationX, translationY);
        animatorSet1.setDuration(500);

        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.play(rotation).before(alpha);
        animatorSet2.play(alpha).before(animatorSet1);
        setUpAnimation(animatorBtn, animatorSet2, R.animator.nest_animatorset_girl_head, mIvFemaleHead);

    }


    private void setUpAnimation(View view, final Animator animator, final int animatorResId, final View targetView){
        view.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.HONEYCOMB)
            @Override
            public void onClick(View v) {
                if (isUseAnimationRes){
                    Animator anim = AnimatorInflater.loadAnimator(PropertyAnimationActivity.this, animatorResId);

                    anim.setTarget(targetView);
                    anim.start();
                }else {
                    animator.start();
                }
            }
        });

    }



}
