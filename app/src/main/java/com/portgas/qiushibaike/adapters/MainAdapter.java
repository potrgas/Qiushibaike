package com.portgas.qiushibaike.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by Administrator on 2015/12/28 0028.
 */
public class MainAdapter extends FragmentPagerAdapter {
    private List<Fragment> items;

    public MainAdapter(FragmentManager fm, List<Fragment> items) {
        super(fm);
        this.items = items;
    }

    @Override
    public Fragment getItem(int position) {
        return items.get(position);
    }

    @Override
    public int getCount() {
        int ret = 0;

        if (items != null) {
            ret = items.size();
        }

        return ret;
    }
}
