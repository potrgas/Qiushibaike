package com.portgas.qiushibaike.viewPagers;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by Administrator on 2015/12/28 0028.
 */

/**
 * 重写主页面中的ViewPager 设置为不可滑动的。
 * 这样就可以不影响其子控件中Fragment 的滑动
 */
public class MainViewPager extends ViewPager {

    public MainViewPager(Context context) {
        this(context, null);
    }

    public MainViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * 直接return  false
     *
     * @param ev
     * @return
     */
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {

        return false;
    }


    /**
     * 直接return  false
     *
     * @param ev
     * @return
     */
    @Override
    public boolean onTouchEvent(MotionEvent ev) {

        return false;
    }
}
