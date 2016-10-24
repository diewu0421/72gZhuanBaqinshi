package com.qf.a72gzhuanba.activity;

import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.qf.a72gzhuanba.R;
import com.qf.a72gzhuanba.adapter.MyVpAdapter;

public class WelcomeActivity extends BaseActivity implements ViewTreeObserver.OnGlobalLayoutListener, View.OnClickListener {


    private ViewPager vp;
    private int[] imagesId;
    private Button btn;

    @Override
    protected void initViews() {
        vp = (ViewPager) findViewById(R.id.vp_id);
        btn = (Button) findViewById(R.id.btn);
        ViewTreeObserver observer = btn.getViewTreeObserver();
        observer.addOnGlobalLayoutListener(this);

    }

    @Override
    protected void initEvent() {
        btn.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btn:
                Intent intent = new Intent(this,MainActivity.class);
                startActivity(intent);
                finish();
                break;
        }
    }
    @Override
    protected void loadData() {
        imagesId = new int[]{
                R.mipmap.bg_guide_01,
                R.mipmap.bg_guide_02,
                R.mipmap.bg_guide_03,
                R.mipmap.bg_guide_04};
        PagerAdapter adapter = new MyVpAdapter(this, imagesId);
        vp.setAdapter(adapter);
        vp.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {

                vp.setCurrentItem(position, true);
                if (position == (imagesId.length - 1)) {
                    btn.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void onGlobalLayout() {
        int width = btn.getWidth();
        int height = btn.getHeight();
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        int widthPixels = getResources().getDisplayMetrics().widthPixels;
        int heightPixels = getResources().getDisplayMetrics().heightPixels;
        params.leftMargin = widthPixels / 2 - width / 2;
        params.topMargin = heightPixels * 3 / 4 ;
        btn.setLayoutParams(params);
    }

}
