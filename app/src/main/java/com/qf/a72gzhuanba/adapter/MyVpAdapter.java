package com.qf.a72gzhuanba.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by Administrator on 2016/10/24 0024.
 */
public class MyVpAdapter extends PagerAdapter {
    private int[] imagesId;
    private Context context;

    public MyVpAdapter(Context context, int[] imagesId) {
        this.context = context;
        this.imagesId = imagesId;
    }

    @Override
    public int getCount() {
        return imagesId.length;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView iv = new ImageView(context);
        iv.setScaleType(ImageView.ScaleType.FIT_XY);
        iv.setImageResource(imagesId[position]);
        container.addView(iv);
        return iv;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((ImageView) object);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
