package com.portgas.qiushibaike.fragments;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.portgas.qiushibaike.R;
import com.portgas.qiushibaike.adapters.QiushiAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class QiushiFragment extends Fragment implements View.OnTouchListener {


    private ViewPager mViewPager;

    public QiushiFragment() {
        // Required empty public constructor
    }

    public static QiushiFragment newInstance() {

        Bundle args = new Bundle();

        QiushiFragment fragment = new QiushiFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View ret = inflater.inflate(R.layout.fragment_qiushi, container, false);

        return ret;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TabLayout mTabLayout = (TabLayout) view.findViewById(R.id.qiushi_tab_layout);

        mViewPager = (ViewPager) view.findViewById(R.id.qiushi_view_pager);

        // 声明
        List<String> items = new ArrayList<>();
        items.add("专项");
        items.add("视频");
        items.add("纯文");
        items.add("纯图");
        items.add("精华");

        QiushiAdapter adapter = new QiushiAdapter(getChildFragmentManager(), items);

        mViewPager.setAdapter(adapter);
        mViewPager.setOnTouchListener(this);

        mTabLayout.setupWithViewPager(mViewPager);

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        float x = event.getX();

        int width = v.getWidth();
        if (x / width > 0.05) {
            mViewPager.requestDisallowInterceptTouchEvent(true);
        } else {
            // 为了补全判断
            mViewPager.requestDisallowInterceptTouchEvent(false);
        }


        return false;
    }
}
