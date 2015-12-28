package com.portgas.qiushibaike.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.portgas.qiushibaike.fragments.ContentFragment;

import java.util.List;

/**
 * Created by Administrator on 2015/12/28 0028.
 */
public class QiushiAdapter extends FragmentPagerAdapter {
    private List<String> items;

    public QiushiAdapter(FragmentManager fm, List<String> items) {
        super(fm);
        this.items = items;
    }

    @Override
    public Fragment getItem(int position) {
        return ContentFragment.newInstance(items.get(position));
    }

    @Override
    public int getCount() {
        int ret = 0;

        if (items != null) {
            ret = items.size();
        }

        return ret;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return items.get(position);
    }
}
