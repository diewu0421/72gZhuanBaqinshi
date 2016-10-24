package com.qf.a72gzhuanba.activity;


import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.qf.a72gzhuanba.R;

public class Welcome0Activity extends BaseActivity {

    private TextView tv;
    private ImageView iv;

    @Override
    protected void initViews() {
        iv = (ImageView) findViewById(R.id.iv);
        tv = (TextView)findViewById(R.id.text);
        ViewTreeObserver tvObserver = tv.getViewTreeObserver();
        tvObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                int height = tv.getHeight();
//                TranslateAnimation translateAnimation = new TranslateAnimation(
//                        Animation.RELATIVE_TO_PARENT,0,Animation.RELATIVE_TO_PARENT,0.5f,
//
//                )
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
}
