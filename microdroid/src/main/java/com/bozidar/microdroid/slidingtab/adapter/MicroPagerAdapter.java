package com.bozidar.microdroid.slidingtab.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.bozidar.microdroid.slidingtab.fragment.MicroTabFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bozidar on 24.04.15..
 */

/**
 * MicroPagerAdapter represents each page as Fragment that is persistently kept in the fragment manager as
 * long as the user can return to page
 */
public class MicroPagerAdapter extends FragmentPagerAdapter {

    private final List<MicroTabFragment> fragments;

    public MicroPagerAdapter(FragmentManager fm) {
        super(fm);
        this.fragments = new ArrayList<>();
    }

    /**
     * Method for adding fragments as tabs
     *
     * @param tab        Fragment which represents tab and extends base MicroTabFrag class
     * @param <MicroTab> Base class for tab fragments
     */
    public <MicroTab extends MicroTabFragment> void addTab(MicroTab tab) {
        tab.setMicroAdapter(this);
        this.fragments.add(tab);
        this.notifyDataSetChanged();
    }

    /**
     * This method may be called by ViewPager to obtain a title to describe a tab
     *
     * @param position position of fragment
     * @return A title for the requested page
     */
    @Override
    public CharSequence getPageTitle(int position) {
        return fragments.get(position).setTabTitle();
    }

    /**
     * Method which return the Fragment with a specified position
     *
     * @param position of fragment
     * @return Fragment associated with a specified position which is stored insie fragments array
     */
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    /**
     * Method which return the number of views available
     *
     * @return the size, or number of views available
     */
    @Override
    public int getCount() {
        return fragments.size();
    }
}