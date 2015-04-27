package com.bozidar.microdroidapp.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.bozidar.microdroid.recyclerview.api.MicroRecyclerAPI;
import com.bozidar.microdroid.recyclerview.manager.MicroRecyclerManager;
import com.bozidar.microdroid.recyclerview.model.MicroSimpleModel;
import com.bozidar.microdroid.slidingtab.fragment.MicroTabFragment;
import com.bozidar.microdroidapp.R;
import com.bozidar.microdroidapp.SortListener;
import com.bozidar.microdroidapp.Sorter;

import java.util.ArrayList;
import java.util.List;


public class SlideFragment extends MicroTabFragment implements SortListener{

    private Sorter sorter;
    private List<MicroSimpleModel> data;


    public static SlideFragment getInstance(String tabTitle){
        SlideFragment fragment= new SlideFragment();
        Bundle args = new Bundle();
        args.putString("title", tabTitle);
        fragment.setArguments(args);
        return fragment;
    }

    public SlideFragment(){
        sorter = new Sorter();
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

        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setRecyclerView(view);
    }

    private void setRecyclerView(View v){
        data = getData();
        RecyclerView recyclerView = (RecyclerView) v.findViewById(R.id.drawertest);
        MicroRecyclerManager manager = MicroRecyclerManager.Builder().setInformation(recyclerView, data, getMicroActivity());
        MicroRecyclerAPI api = manager.buildDetailRecyclerView();
        api.createRecyclerView();
    }

    public static List<MicroSimpleModel> getData() {
        List<MicroSimpleModel> data = new ArrayList<>();
        int[] icons = {com.bozidar.microdroid.R.drawable.abc_btn_rating_star_on_mtrl_alpha, com.bozidar.microdroid.R.drawable.abc_btn_rating_star_on_mtrl_alpha, com.bozidar.microdroid.R.drawable.abc_btn_rating_star_on_mtrl_alpha};
        String[] titles = {"Tab Activity", "Second", "Third title"};
        for (int i = 0; i < 50; i++) {
            MicroSimpleModel info = new MicroSimpleModel();
            info.setText(titles[i%2]);
            info.setImageResource(icons[i%2]);
            data.add(info);
        }
        return data;
    }

    @Override
    public void onSortByName() {
        Toast.makeText(getMicroActivity(), data.get(0).getText(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onSortByDate() {

    }

    @Override
    public void onSortByRating() {

    }
}
