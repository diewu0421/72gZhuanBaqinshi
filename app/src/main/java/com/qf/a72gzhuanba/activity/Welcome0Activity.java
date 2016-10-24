package com.qf.a72gzhuanba.activity;


import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.SystemClock;
import android.util.Log;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.qf.a72gzhuanba.R;

import java.util.Timer;
import java.util.TimerTask;

public class Welcome0Activity extends BaseActivity implements Animation.AnimationListener {

    private TextView tv;
    private ImageView iv;

    @Override
    protected void initViews() {
        iv = (ImageView) findViewById(R.id.iv);
        tv = (TextView) findViewById(R.id.text);
        final int heightPixels = getResources().getDisplayMetrics().heightPixels;
        final int widthPixels = getResources().getDisplayMetrics().widthPixels;
        ViewTreeObserver tvObserver = tv.getViewTreeObserver();
        tvObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                final int height = tv.getHeight();
                ObjectAnimator tvAnimator = ObjectAnimator.ofFloat(tv, "translationX", 0, widthPixels * 2 / 5);
                tvAnimator.setDuration(500);
                tvAnimator.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        TranslateAnimation ivTrans = new TranslateAnimation(
                                0, 0, 0, heightPixels*1 / 3 - height
                        );
                        ivTrans.setDuration(1000);
                        ivTrans.setFillAfter(true);
                        ivTrans.setInterpolator(Welcome0Activity.this, android.R.anim.bounce_interpolator);
                        ivTrans.setAnimationListener(Welcome0Activity.this);
                        iv.startAnimation(ivTrans);
                    }
                });
                tvAnimator.start();

                
            }
        });
    }

    @Override
    protected void initEvent() {

    }

    @Override
    protected void loadData() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_welcome0;
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                SharedPreferences sp = getSharedPreferences("mysp", MODE_PRIVATE);
                boolean isFirst = sp.getBoolean("isFirst", true);
                Intent intent = null;
                if(isFirst){
                    intent = new Intent(Welcome0Activity.this,WelcomeActivity.class);
                }else {
                    intent = new Intent(Welcome0Activity.this,MainActivity.class);
                }
                startActivity(intent);
                finish();
            }
        },1000);
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
