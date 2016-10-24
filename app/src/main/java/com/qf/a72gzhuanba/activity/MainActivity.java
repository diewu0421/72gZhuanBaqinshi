package com.qf.a72gzhuanba.activity;

import android.content.SharedPreferences;

import com.qf.a72gzhuanba.R;

public class MainActivity extends BaseActivity {

    private SharedPreferences sp;

    @Override
    protected void loadData() {
        sp = getSharedPreferences("mysp", MODE_PRIVATE);
        if (sp != null){
            boolean isFirst = sp.getBoolean("isFirst", true);
            if (isFirst){
                SharedPreferences.Editor edit = sp.edit();
                edit.putBoolean("isFirst", false);
                edit.commit();
            }
        }

    }

    @Override
    protected void initEvent() {

    }

    @Override
    protected void initViews() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main2;
    }
}
