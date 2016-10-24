package com.qf.a72gzhuanba.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Administrator on 2016/10/24 0024.
 */
public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        //初始化控件
        initViews();
        //初始化事件
        initEvent();
        //初始化数据
        loadData();
    }

    //初始化事件
    protected abstract void initViews();
    //初始化控件
    protected abstract void initEvent();
    //初始化数据
    protected abstract void loadData();
    protected abstract int getLayoutId();
}
