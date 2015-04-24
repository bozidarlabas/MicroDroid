package com.bozidar.microdroidapp.Activity;

import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;

import com.bozidar.microdroid.drawer.MicroDrawerActivity;
import com.bozidar.microdroid.recyclerview.adapter.MicroRecyclerAdapter;
import com.bozidar.microdroid.slidingtab.manager.MicroTabManager;
import com.bozidar.microdroidapp.Fragment.SlideFragment;
import com.bozidar.microdroidapp.R;
import com.rey.material.widget.TabPageIndicator;

import butterknife.InjectView;


/**
 * Created by bozidar on 19.04.15..
 */
public class DrawerActivity extends MicroDrawerActivity implements MicroRecyclerAdapter.onMicroItemCLickListener{

    @InjectView(R.id.pagermy)
    ViewPager viewPager;

    @InjectView(R.id.tabs)
    TabPageIndicator slidingTabLayout;

    @Override
    public void init() {
        MicroTabManager microTabManager = new MicroTabManager(getSupportFragmentManager(), viewPager, slidingTabLayout);
        microTabManager.addTab(SlideFragment.getInstance("Naziv 1"));
        microTabManager.addTab(SlideFragment.getInstance("Naziv 2"));
        microTabManager.addTab(SlideFragment.getInstance("Naziv 3"));
        microTabManager.init();
    }

    @Override
    public int setupToolbar() {
        return R.id.app_bar;
    }

    @Override
    public int setupLayoutRes() {
        return R.layout.activity_drawer;
    }

    @Override
    public int setupMenuRes() {
        return R.menu.micro_menu;
    }

    @Override
    public int setupDrawerLayoutRes() {
        return R.id.drawer_layout;
    }

    @Override
    public int setupHeaderImageRes() {
        return R.drawable.header;
    }

    @Override
    public int setupDrawerFragmentRes() {
        return R.id.fragmen_drawer;
    }

    @Override
    public void microItemClicked(View view, int position) {
        Log.d("clicked", position + "");
    }
}

