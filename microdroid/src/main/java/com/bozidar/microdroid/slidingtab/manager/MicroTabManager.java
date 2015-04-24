package com.bozidar.microdroid.slidingtab.manager;

import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;

import com.bozidar.microdroid.slidingtab.adapter.MicroPagerAdapter;
import com.bozidar.microdroid.slidingtab.fragment.MicroTabFrag;
import com.bozidar.microdroid.slidingtab.layout.SlidingTabLayout;

/**
 * Created by bozidar on 24.04.15..
 */
public class MicroTabManager {

    private FragmentManager fragmentManager;
    private MicroPagerAdapter microPagerAdapter;
    private ViewPager viewPager;
    private SlidingTabLayout slidingTabLayout;

    public MicroTabManager(FragmentManager fragmentManager, ViewPager viewPager,  SlidingTabLayout slidingTabLayout){
        this.fragmentManager = fragmentManager;
        this.viewPager = viewPager;
        this.slidingTabLayout = slidingTabLayout;
        main();
    }

    private void main(){
        microPagerAdapter = new MicroPagerAdapter(fragmentManager);
    }

    public <MicroTab extends MicroTabFrag>void addTab(MicroTab fragment){
        microPagerAdapter.addTab(fragment);
    }

    public void init(){
        viewPager.setAdapter(microPagerAdapter);
        slidingTabLayout.setViewPager(viewPager);
    }
}
