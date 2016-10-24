package com.qf.a72gzhuanba.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Administrator on 2016/10/24 0024.
 */
public abstract class BaseFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), container, false);
        //初始化控件
        initViews();
        //初始化事件
        initEvent();
        //初始化数据
        loadData();
        return view;
    }
    //初始化事件
    protected abstract void initEvent();
    //初始化数据
    protected abstract void loadData();
    //初始化控件
    protected abstract void initViews();

    protected abstract int getLayoutId();
}
