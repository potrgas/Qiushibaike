package com.portgas.qiushibaike;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SlidingPaneLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.portgas.qiushibaike.adapters.MainAdapter;
import com.portgas.qiushibaike.fragments.MyselfFragment;
import com.portgas.qiushibaike.fragments.NearbyFragment;
import com.portgas.qiushibaike.fragments.QiushiFragment;
import com.portgas.qiushibaike.fragments.QiuyouquanFragment;
import com.portgas.qiushibaike.fragments.SettingsFragment;
import com.portgas.qiushibaike.fragments.XiaozhitiaoFragment;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private ViewPager mViewPager;
    private NavigationView mNavigationView;
    private List<Fragment> items;

    private SlidingPaneLayout mSlidingPaneLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSlidingPaneLayout = (SlidingPaneLayout) findViewById(R.id.sliding_pane_layout);

        mViewPager = (ViewPager) findViewById(R.id.main_view_pager);

        items = new ArrayList<>();

        // 在主界面添加Fragment到Adapter中
        // 糗事
        Fragment fragment = new QiushiFragment();
        items.add(fragment);

        //糗友圈
        fragment = new QiuyouquanFragment();
        items.add(fragment);

        //发现
        fragment = new NearbyFragment();
        items.add(fragment);

        //小纸条
        fragment = new XiaozhitiaoFragment();
        items.add(fragment);

        //设置
        fragment = new SettingsFragment();
        items.add(fragment);

        //我的
        fragment = new MyselfFragment();
        items.add(fragment);

        MainAdapter adapter = new MainAdapter(getSupportFragmentManager(), items);

        mViewPager.setAdapter(adapter);


        mNavigationView = (NavigationView) findViewById(R.id.main_navigation);

        //NavigationView添加监听
        mNavigationView.setNavigationItemSelectedListener(this);

        //显示Home
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {

            actionBar.setLogo(R.drawable.splash_logo);
            actionBar.setTitle("糗事百科");
            Drawable drawable = getResources().getDrawable(R.mipmap.ic_launcher);
//            actionBar.setBackgroundDrawable(drawable);
//            actionBar.setDisplayUseLogoEnabled(true);
//            actionBar.setDisplayShowTitleEnabled(true);
            actionBar.setDisplayOptions(ActionBar.DISPLAY_USE_LOGO);
            actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_TITLE);


//            actionBar.show();
        }


    }

    /**
     * toggle控制弹出左侧菜单
     *
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int index = 0;
        switch (item.getItemId()) {
            case R.id.item_qs:
                //糗事
                index = 0;

                break;
            case R.id.item_qyq:
                //糗友圈
                index = 1;
                break;
            case R.id.item_fx:
                //发现
                index = 2;
                break;
            case R.id.item_xzt:
                //小纸条
                index = 3;
                break;


            case R.id.group_settings:
                //设置
                index = 4;
                break;
            case R.id.group_myself:
                //我的
                index = 5;
                break;
            case R.id.group_quit:
                //退出
                ActivityCompat.finishAffinity(this);
                break;
        }

        mViewPager.setCurrentItem(index, false);
        mSlidingPaneLayout.closePane();
        return true;

    }

}
