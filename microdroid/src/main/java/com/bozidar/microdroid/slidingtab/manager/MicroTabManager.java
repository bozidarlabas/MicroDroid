package com.bozidar.microdroid.slidingtab.manager;

import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;

import com.bozidar.microdroid.slidingtab.adapter.MicroPagerAdapter;
import com.bozidar.microdroid.slidingtab.fragment.MicroTabFragment;
import com.rey.material.widget.TabPageIndicator;

/**
 * Created by bozidar on 24.04.15..
 */

/**
 * Manager class which will handle all the initialization of objects which is used for tabs
 */
public class MicroTabManager {

    private FragmentManager fragmentManager;
    private MicroPagerAdapter microPagerAdapter;
    private ViewPager viewPager;
    private TabPageIndicator slidingTabLayout;

    public MicroTabManager(FragmentManager fragmentManager, ViewPager viewPager, TabPageIndicator slidingTabLayout) {
        this.fragmentManager = fragmentManager;
        this.viewPager = viewPager;
        this.slidingTabLayout = slidingTabLayout;
        main();
    }

    /**
     * Main method which will be called from constructor
     */
    private void main() {
        microPagerAdapter = new MicroPagerAdapter(fragmentManager);
    }

    /**
     * Method responsible for adding tab. Its called inside activity where tabs will be shown.
     *
     * @param fragment   Fragment which will represent specific tab
     * @param <MicroTab> Base class for tab fragment
     */
    public <MicroTab extends MicroTabFragment> void addTab(MicroTab fragment) {
        microPagerAdapter.addTab(fragment);
    }

    /**
     * Method responsible for setting up viewPager and adding this pager to specified layout
     */
    public void init() {
        viewPager.setAdapter(microPagerAdapter);
        slidingTabLayout.setViewPager(viewPager);
    }
}
