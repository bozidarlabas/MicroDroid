package com.bozidar.microdroid.drawer;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bozidar.microdroid.R;
import com.bozidar.microdroid.base.MicroFragment;
import com.bozidar.microdroid.recyclerview.api.MicroRecyclerAPI;
import com.bozidar.microdroid.recyclerview.manager.MicroRecyclerManager;
import com.bozidar.microdroid.recyclerview.model.MicroSimpleModel;

import java.util.ArrayList;
import java.util.List;


public class MicroFragmentDrawer extends MicroFragment{

    private ActionBarDrawerToggle drawerToggle;
    private int headerImageRes;
    private ImageView headerImageViewRes;
    private LinearLayout containerLayout;

    @Override
    public void init() {
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        setUpRecyclerView(view);
        headerImageViewRes = (ImageView) view.findViewById(R.id.ivHeader);
        containerLayout = (LinearLayout)view.findViewById(R.id.container);
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public int setLayoutResource() {
        return R.layout.micro_fragment_drawer;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        setupHeaderImage();
        super.onActivityCreated(savedInstanceState);
    }

    private void setUpRecyclerView(View view) {
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.drawerlist);
        MicroRecyclerManager manager = new MicroRecyclerManager.Builder(getMicroActivity()).data(getData()).recyclerView(recyclerView).build();
        MicroRecyclerAPI recyclerAPI = manager.buildSimpleRecyclerView();
        recyclerAPI.createRecyclerView();
    }

    private void setupHeaderImage() {
        switch (headerImageRes){
            case 0:
               containerLayout.removeView(headerImageViewRes);
                break;
            default:
                headerImageViewRes.setImageResource(headerImageRes);
        }
    }

    public void setUp(DrawerLayout drawerLayout, Toolbar toolbar, int headerImageRes) {
        this.headerImageRes = headerImageRes;
        this.drawerToggle = new ActionBarDrawerToggle(getMicroActivity(), drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getMicroActivity().supportInvalidateOptionsMenu();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                getMicroActivity().supportInvalidateOptionsMenu();
            }
        };
        drawerLayout.setDrawerListener(drawerToggle);
        drawerLayout.post(new Runnable() {

            @Override
            public void run() {
                drawerToggle.syncState();
            }
        });
    }

    public static List<MicroSimpleModel> getData() {
        List<MicroSimpleModel> data = new ArrayList<>();
        int[] icons = {R.drawable.abc_btn_rating_star_on_mtrl_alpha, R.drawable.abc_btn_rating_star_on_mtrl_alpha, R.drawable.abc_btn_rating_star_on_mtrl_alpha};
        String[] titles = {"First title", "Second", "Third title"};
        for (int i = 0; i < titles.length && i < icons.length; i++) {
            MicroSimpleModel info = new MicroSimpleModel();
            info.setText(titles[i]);
            info.setImageResource(icons[i]);
            data.add(info);
        }
        return data;
    }
}

//ActionBarDrawerToggle
//Provides a handy way to tie together the functionality of DrawerLayout and the framework ActionBar
//to implement the recommended design for navigation drawers

//ActionBarDrawerToggle use two methods:
//onConfigurationChanged
//onOptionItemSelected

//syncState() is called to synchronize the indicator with the state of the linked DrawerLayout