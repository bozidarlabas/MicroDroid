package com.bozidar.microdroidapp.Activity;

import android.content.Intent;
import android.view.View;

import com.bozidar.microdroid.drawer.MicroDrawerActivity;
import com.bozidar.microdroid.recyclerview.adapter.MicroRecyclerAdapter;
import com.bozidar.microdroidapp.R;


/**
 * Created by bozidar on 19.04.15..
 */
public class DrawerActivity extends MicroDrawerActivity implements MicroRecyclerAdapter.onMicroItemCLickListener{



    @Override
    public void init() {

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
        switch(position){
            case 0: startActivity(new Intent(this,TabActivity.class));
        }
    }
}

