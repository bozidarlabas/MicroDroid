package com.bozidar.microdroidapp.Fragment;

import android.os.Bundle;
import android.widget.TextView;

import com.bozidar.microdroidapp.R;
import com.bozidar.microdroid.slidingtab.fragment.MicroTabFragment;

import butterknife.InjectView;


public class SlideFragment extends MicroTabFragment {

    @InjectView(R.id.tvSlide)
    TextView tvSlide;

    public static SlideFragment getInstance(String tabTitle){
        SlideFragment fragment= new SlideFragment();
        Bundle args = new Bundle();
        args.putString("title", tabTitle);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public String setTabTitle() {
        return getArguments().getString("title");
    }

    @Override
    public int setLayoutResource() {
        return R.layout.fragment_slide;
    }

    @Override
    public void init() {
        Bundle bundle = getArguments();
        if (bundle != null) {
            //Do something
        }
    }


}
