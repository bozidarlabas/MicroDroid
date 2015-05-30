package com.bozidar.microdroidapp.Activity;

import android.content.Intent;
import android.view.MenuItem;
import android.view.View;

import com.bozidar.microdroidapp.Fragment.DinamicFragment;
import com.bozidar.microdroid.base.MicroActivity;
import com.bozidar.microdroidapp.R;

import butterknife.OnClick;


public class MainActivity extends MicroActivity {


    @Override
    public void init() {
        setFragment(R.id.mylayout, new DinamicFragment());
    }

    @Override
    public int setupToolbar() {
        return R.id.app_bar;
    }

    @Override
    public int setupLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    public int setupMenuRes() {
        return R.menu.micro_menu;
    }

    @OnClick(R.id.btnDrawerActivity)
    public void onClick(View view) {
        startActivity(new Intent(this, DrawerActivity.class));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
