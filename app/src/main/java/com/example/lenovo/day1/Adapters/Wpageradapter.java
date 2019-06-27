package com.example.lenovo.day1.Adapters;


import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * @author: 汐er
 * @QQ: 2044273990
 * @date: 2019/6/26
 * @Week: 星期三
 * @GitHub: https://github.com/HanXier
 */
public class Wpageradapter extends PagerAdapter{

    ArrayList<ImageView>s;

    public Wpageradapter(ArrayList <ImageView> s) {
        this.s = s;
    }

    @Override
    public int getCount() {
        return s.size();
    }

    /**
     * 判断当前分页是不是view
     * 由于ViewPager里面的分页可以填入Fragment
     *
     * @param view
     * @param object
     * @return
     */
    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    /**
     * 得到---->暂时是没有用的
     *
     * @param object
     * @return
     */
    @Override
    public int getItemPosition(Object object) {
        return super.getItemPosition(object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(s.get(position));
        //每次滑动的时候把视图添加到viewpager
        return s.get(position);
    }

    /**
     * 清理内存
     * 从第一页滑动到第二页，此时第一页的内存应该释放
     *
     * @param container
     * @param position
     * @param object
     */
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(s.get(position));//释放滑动过后的前一页
    }

}
